package com.Spring.TodoList.request;

import java.util.Date;

public class AddTaskRequest {
    private String details;
    private Date dueDate;

    public AddTaskRequest() {
    }

    public AddTaskRequest(String details, Date dueDate) {
        this.details = details;
        this.dueDate = dueDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
