package com.Spring.TodoList.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String email;
    private String favoriteProgrammingLanguage;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Task> todoList = new ArrayList<>();

    public Person() {
    }

    public Person(Integer id, String name, String email, String favoriteProgrammingLanguage) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.favoriteProgrammingLanguage = favoriteProgrammingLanguage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
