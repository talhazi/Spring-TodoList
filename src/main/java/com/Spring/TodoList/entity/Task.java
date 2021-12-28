package com.Spring.TodoList.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.util.Date;

@Entity
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackageClasses=Task.class)
public class Task {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String title;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ownerId_id", nullable=false)
    private String ownerId;
    private boolean status = Boolean.FALSE;
    private String details;
    private Date dueDate;

    public Task() {
    }

    public Task(String id, String title, boolean status, String details, Date dueDate) {
        this.id = id; //why?!
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

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public String getDetails() {
        return this.details;
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
