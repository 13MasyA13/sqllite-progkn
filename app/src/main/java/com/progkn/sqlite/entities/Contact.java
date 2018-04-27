package com.progkn.sqlite.entities;

public class Contact {

    private String name;
    private String email;

    public Contact(){

    }

    public Contact(String name, String email) {
        this.name = name;
        this.email = email;
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

    @Override
    public String toString() {
        return "Name : " + name + " " + " Email : " + email;
    }
}
