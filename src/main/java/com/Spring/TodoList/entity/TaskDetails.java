package com.Spring.TodoList.entity;

import javax.persistence.*;

/**
 * The TaskDetails class holds all the information required for a Task, and it's mapped to an entity in the database,
 * as each field in the class is a column in the table, and each instance of it created is a row in the table.
 */
@Entity
public class TaskDetails {

    public enum Status{
        active,
        done
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String title;
    private String ownerId;
    private Status status = Status.active;
    private String details;
    private String dueDate;

    /**
     * Empty constructor for the PersonDetails class
     */
    public TaskDetails() {
    }

    /**
     * Constructor for the TaskDetails class
     *
     * @param title may be null
     * @param status may be null
     * @param details may be null
     * @param dueDate may be null
     */
    public TaskDetails(String title, Status status, String details, String dueDate) {
        this.title = title;
        this.status = status;
        this.details = details;
        this.dueDate = dueDate;
    }

    /**
     * getter for the id field
     *
     * @return the id field, not null
     */
    public String getId() {
        return this.id;
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
     * getter for the ownerId field
     *
     * @return the ownerId field, not null
     */
    public String getOwnerId() {
        return this.ownerId;
    }

    /**
     * setter for the ownerId field
     *
     * @param ownerId not null
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * getter for the status field
     *
     * @return the status field, not null
     */
    public Status getStatus() {
        return this.status;
    }

    /**
     * setter for the status field
     *
     * @param status not null
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * getter for the details field
     *
     * @return the details field, not null
     */
    public String getDetails() {
        return this.details;
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
}
