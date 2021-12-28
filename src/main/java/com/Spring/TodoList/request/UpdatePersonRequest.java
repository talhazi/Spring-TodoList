package com.Spring.TodoList.request;

public class UpdatePersonRequest {
    private String email;
    private String favoriteProgrammingLanguage;
    private String name;

    public UpdatePersonRequest(String email, String favoriteProgrammingLanguage, String name) {
        this.email = email;
        this.favoriteProgrammingLanguage = favoriteProgrammingLanguage;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getFavoriteProgrammingLanguage() {
        return favoriteProgrammingLanguage;
    }

    public String getName() {
        return name;
    }

}
