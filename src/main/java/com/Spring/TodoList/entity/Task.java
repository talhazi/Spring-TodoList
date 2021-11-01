package com.Spring.TodoList.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Task {

    @Id
    private String id;

    //private String ownerId;
    private boolean status = Boolean.FALSE;
    private String details;
    private Date dueDate;

    public Task() {
    }

    public Task(String id, String ownerId, boolean status, String details, Date dueDate) {
        this.id = id;
        this.status = status;
        this.details = details;
        this.dueDate = dueDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
