package com.progkn.sqlite.entities;

public class Student {

    private int ID;
    private String firstName;
    private String lastName;
    private String marks;

    public Student(){

    }

    public Student(int ID, String firstName, String lastName, String marks) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.marks = marks;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }
}
