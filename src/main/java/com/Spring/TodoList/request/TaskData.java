package com.Spring.TodoList.request;

import com.Spring.TodoList.entity.TaskDetails;

public class TaskData {

    private String title;
    private String details;
    private String dueDate;
    private TaskDetails.Status status;


    public TaskData(String title, String details, String dueDate, TaskDetails.Status status) {
        this.title = title;
        this.details = details;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public TaskDetails.Status getStatus() {
        return this.status;
    }

    public void setStatus(TaskDetails.Status status) {
        this.status = status;
    }
}
