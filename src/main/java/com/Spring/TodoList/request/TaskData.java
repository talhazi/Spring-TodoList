package com.Spring.TodoList.request;

import com.Spring.TodoList.controller.TaskController;
import com.Spring.TodoList.entity.TaskDetails;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * The TaskData class serves as an aid for the ORM technique that the system uses, mapping between the
 * {@link TaskDetails} class and TaskDetails entity. Once the {@link TaskController} gets a request with a body,
 * the JSON body and its fields(not necessarily all of them), a TaskData instance is created with the matching fields
 * filled.
 */
public class TaskData {

    private String title;
    private String details;
    private String dueDate;
    private TaskDetails.Status status;

    /**
     * Constructor for the TaskData class
     *
     * @param title may be null
     * @param details may be null
     * @param dueDate may be null
     * @param status may be null
     */
    public TaskData(String title, String details, String dueDate, TaskDetails.Status status) {
        this.title = title;
        this.details = details;

        DateValidator validator = new DateValidatorUsingLocalDate("yyyy-MM-dd");
        if (validator.isValid(dueDate)){
            this.dueDate = dueDate;
        }
        else{
            throw new IllegalArgumentException("due date not valid format");
        }

        this.status = status;
    }

    /**
     * getter for the title field
     *
     * @return the title field, not null
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * setter for the title field
     *
     * @param title not null
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * getter for the details field
     *
     * @return the details field, not null
     */
    public String getDetails() {
        return details;
    }

    /**
     * setter for the details field
     *
     * @param details not null
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * getter for the dueDate field
     *
     * @return the dueDate field, not null
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * setter for the dueDate field
     *
     * @param dueDate not null
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * getter for the status field
     *
     * @return the status field, not null
     */
    public TaskDetails.Status getStatus() {
        return this.status;
    }

    /**
     * setter for the status field
     *
     * @param status not null
     */
    public void setStatus(TaskDetails.Status status) {
        this.status = status;
    }
}
