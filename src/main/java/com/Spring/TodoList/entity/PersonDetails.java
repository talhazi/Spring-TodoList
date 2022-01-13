package com.Spring.TodoList.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The PersonDetails class holds all the information required for a Person, and it's mapped to an entity in the database,
 * as each field in the class is a column in the table, and each instance of it created is a row in the table.
 */
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

    /**
     * Empty constructor for the PersonDetails class
     */
    public PersonDetails() {
        this.activeTaskCount = 0;
    }

    /**
     * Constructor for the PersonDetails class
     *
     * @param name may be null
     * @param email must be in Email format("NNNN@MMM.XX") ,may be null
     * @param favoriteProgrammingLanguage may be null
     */
    public PersonDetails(String name, String email, String favoriteProgrammingLanguage) {
        this.name = name;
        this.email = email;
        this.favoriteProgrammingLanguage = favoriteProgrammingLanguage;
        this.activeTaskCount = 0;
    }

    /**
     * getter for the id field
     *
     * @return the id field, not null
     */
    public String getId() { return this.id; }

    /**
     * getter for the name field
     *
     * @return the name field, not null
     */
    public String getName() {
        return this.name;
    }

    /**
     * setter for the name field
     *
     * @param name not null
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for the email field
     *
     * @return the email field, not null
     */
    public String getEmail() { return this.email; }

    /**
     * setter for the email field
     *
     * @param email not null
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getter for the favoriteProgrammingLanguage field
     *
     * @return the favoriteProgrammingLanguage field, not null
     */
    public String getFavoriteProgrammingLanguage() {
        return this.favoriteProgrammingLanguage;
    }

    /**
     *  setter for the favoriteProgrammingLanguage field
     *
     * @param favoriteProgrammingLanguage not null
     */
    public void setFavoriteProgrammingLanguage(String favoriteProgrammingLanguage) {
        this.favoriteProgrammingLanguage = favoriteProgrammingLanguage;
    }

    /**
     * getter for the todoList field
     *
     * @return the todoList field, not null
     */
    public List<TaskDetails> getTodoList() {
        return this.todoList;
    }

    /**
     * setter for the todoList field
     *
     * @param todoList not null
     */
    public void setTodoList(List<TaskDetails> todoList) {
        this.todoList = todoList;
    }

    /**
     * getter for the activeTaskCount field
     *
     * @return the activeTaskCount field, not null
     */
    public Integer getActiveTaskCount() { return this.activeTaskCount; }

    /**
     * setter for the activeTaskCount field
     *
     * @param activeTaskCount not null
     */
    public void setActiveTaskCount(Integer activeTaskCount) {
        this.activeTaskCount = activeTaskCount;
    }

    /**
     * Adds a TaskDetail to the todoList field and sets the activeTaskCount field + 1 accordingly
     *
     * @param task not null
     */
    public void addTask(TaskDetails task){
        this.todoList.add(task);
        this.activeTaskCount++;
        task.setOwnerId(this.id);
    }

    /**
     * Removes a TaskDetail to the todoList field and sets the activeTaskCount field - 1 accordingly
     *
     * @param task not null
     */
    public void removeTask(TaskDetails task){
        this.todoList.remove(task);
        this.activeTaskCount--;
    }
}
