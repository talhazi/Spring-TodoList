package com.Spring.TodoList.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PersonDetails {

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
    private List<TaskDetails> todoList = new ArrayList<>();

    public PersonDetails() {
        this.activeTaskCount = 0;
    }

    public PersonDetails(String name, String email, String favoriteProgrammingLanguage) {
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

    public List<TaskDetails> getTodoList() {
        return this.todoList;
    }

    public void setTodoList(List<TaskDetails> todoList) {
        this.todoList = todoList;
    }

    public Integer getActiveTaskCount() { return this.activeTaskCount; }

    public void setActiveTaskCount(Integer activeTaskCount) {
        this.activeTaskCount = activeTaskCount;
    }

    public void addTask(TaskDetails task){
        this.todoList.add(task);
        this.activeTaskCount++;
        task.setOwnerId(this.id);
    }

    public void removeTask(TaskDetails task){
        this.todoList.remove(task);
        this.activeTaskCount--;
    }
}
