package com.Spring.TodoList.request;

import com.Spring.TodoList.entity.Task;

public class AddTaskRequest {

    private String title;
    private String details;
    private String dueDate;
    private Task.Status status;


    public AddTaskRequest(String title, String details, String dueDate, Task.Status status) {
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

    public Task.Status getStatus() {
        return this.status;
    }

    public void setStatus(Task.Status status) {
        this.status = status;
    }
}
