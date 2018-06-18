package com.javacourse.model;

import java.util.UUID;

public class User {
    private UUID id;
    private String login;
    private String email;

    public User(String login, String email) {
        this.id = UUID.randomUUID();
        this.login = login;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
