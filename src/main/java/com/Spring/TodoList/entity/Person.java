package com.Spring.TodoList.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
//@Configuration
//@EnableAutoConfiguration
//@EntityScan(basePackageClasses=Person.class)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;
    private String email;
    private String favoriteProgrammingLanguage;
    private Integer activeTaskCount;

    @OneToMany(
            mappedBy = "ownerId",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Task> todoList = new ArrayList<>();

    public Person() {
        this.activeTaskCount = 0;
    }

    public Person(String name, String email, String favoriteProgrammingLanguage) {
        this.name = name;
        this.email = email;
        this.favoriteProgrammingLanguage = favoriteProgrammingLanguage;
        this.activeTaskCount = 0;
    }

    public String getId() { return this.id; }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() { return this.email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFavoriteProgrammingLanguage() {
        return this.favoriteProgrammingLanguage;
    }

    public void setFavoriteProgrammingLanguage(String favoriteProgrammingLanguage) {
        this.favoriteProgrammingLanguage = favoriteProgrammingLanguage;
    }

    public List<Task> getTodoList() {
        return this.todoList;
    }

    public void setTodoList(List<Task> todoList) {
        this.todoList = todoList;
    }

    public Integer getActiveTaskCount() { return this.activeTaskCount; }

    public void setActiveTaskCount(Integer activeTaskCount) {
        this.activeTaskCount = activeTaskCount;
    }

    public void addTask(Task task){
        this.todoList.add(task);
        this.activeTaskCount++;
        task.setOwnerId(this.id);
    }

    public void removeTask(Task task){
        this.todoList.remove(task);
        this.activeTaskCount--;
    }
}
