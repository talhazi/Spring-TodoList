package com.Spring.TodoList.request;

public class AddPersonRequest {
    private String name;
    private String email;

    public AddPersonRequest(String name, String email, String favoriteProgrammingLanguage) {
        this.name = name;
        this.email = email;
        this.favoriteProgrammingLanguage = favoriteProgrammingLanguage;
    }

    public String getName() { return name; }

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

    private String favoriteProgrammingLanguage;
}
