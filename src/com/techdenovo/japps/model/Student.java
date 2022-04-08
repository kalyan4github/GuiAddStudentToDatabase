package com.techdenovo.japps.model;

public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private String collegeName;

    public Student() {
    }

    public Student(String firstName, String lastName, String collegeName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.collegeName = collegeName;
    }

    public Student(long id, String firstName, String lastName, String collegeName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.collegeName = collegeName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
}
