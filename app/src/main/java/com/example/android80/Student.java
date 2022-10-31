package com.example.android80;

public class Student {
    private Integer id;
    private String email;
    private String password;

    public Student() {
    }

    public Student(String email, String password) {
        this.email = email;
        this.password = password;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student[password=" + password + ",id=" + id + ",email=" + email + "]";
    }
}
