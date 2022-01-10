package com.Spring.TodoList.request;

import javax.validation.constraints.Email;
import com.Spring.TodoList.entity.PersonDetails;
import com.Spring.TodoList.controller.PersonController;

import java.util.regex.Pattern;

/**
 * The PersonData class serves as an aid for the ORM technique that the system uses, mapping between the
 * {@link PersonDetails} class and PersonDetails entity. Once the {@link PersonController} gets a request with a body,
 * the JSON body and its fields(not necessarily all of them), a PersonData instance is created with the matching fields
 * filled.
 */

public class PersonData {
    private String name;
    private String email;
    private String favoriteProgrammingLanguage;

    /**
     * Constructor for the PersonData class
     *
     * @param name may be null
     * @param email must be in Email format("NNNN@MMM.XX") ,may be null
     * @param favoriteProgrammingLanguage may be null
     */
    public PersonData(String name,String email, String favoriteProgrammingLanguage) throws Exception {
        this.name = name;
        if(!Pattern.matches("^[\\w.-]+@[[\\w-]+.]+[\\w-]$",email)){
            throw new Exception("not a valid email");
        }
        this.email = email;
        this.favoriteProgrammingLanguage = favoriteProgrammingLanguage;
    }

    /**
     * getter for the name field
     *
     * @return the name field, not null
     */
    public String getName() { return name; }

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
    public String getEmail() {
        return email;
    }

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
        return favoriteProgrammingLanguage;
    }

    /**
     *  setter for the favoriteProgrammingLanguage field
     *
     * @param favoriteProgrammingLanguage not null
     */
    public void setFavoriteProgrammingLanguage(String favoriteProgrammingLanguage) {
        this.favoriteProgrammingLanguage = favoriteProgrammingLanguage;
    }
}
