package com.example.dao.Model.student;

public class Student {
    private int id;
    private String name;
    private String email;
    private boolean active;

    public Student(int id, String name, String email, boolean active) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.active = active;
    }

    public Student() {
    }

    public Student(String name, String email, boolean active) {
        super();
        this.name = name;
        this.email = email;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String printBioData() {
        return "Student: " + name + ", email=" + email + ", active=" + active;
    }

    @Override
    public String toString() {
        return "Student(id:" + id + "): " + name + ", email=" + email + ", active=" + active;
    }

}
