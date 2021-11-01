package com.Spring.TodoList.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    @Id
    private String id;

    private String name;
    private String email;
    private String favoriteProgrammingLanguage;

    @OneToMany
    private List<Task> todoList = new ArrayList<>();

    public Person() {
    }

    public Person(String id, String name, String email, String favoriteProgrammingLanguage, List<Task> todoList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.favoriteProgrammingLanguage = favoriteProgrammingLanguage;
        this.todoList = todoList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFavoriteProgrammingLanguage() {
        return favoriteProgrammingLanguage;
    }

    public void setFavoriteProgrammingLanguage(String favoriteProgrammingLanguage) {
        this.favoriteProgrammingLanguage = favoriteProgrammingLanguage;
    }

    public List<Task> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Task> todoList) {
        this.todoList = todoList;
    }
}
