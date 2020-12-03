package com.example.orderfood_app.model;

public class Users {
    private String Name;
    private String Password;

    public Users() {
    }

    public Users(String name, String password) {
        Name = name;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
