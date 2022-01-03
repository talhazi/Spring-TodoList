package com.Spring.TodoList.entity;

import javax.persistence.*;

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

    public TaskDetails() {
    }

    public TaskDetails(String title, Status status, String details, String dueDate) {
        this.title = title;
        this.status = status;
        this.details = details;
        this.dueDate = dueDate;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return this.status;
    }

    public String getDetails() {
        return this.details;
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
}
