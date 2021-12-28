package com.Spring.TodoList.request;

import java.util.Date;

public class AddTaskRequest {
    private String title;
    private String details;
    private Date dueDate;
    private boolean status;

//    public AddTaskRequest() {
////    }
    //why do we need an empty constructor?!

    public AddTaskRequest(String title, String details, Date dueDate, boolean status) {
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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
