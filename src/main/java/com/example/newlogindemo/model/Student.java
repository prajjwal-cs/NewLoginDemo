/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 05-04-2022
Time: 01:37
File: Student.java 

*/

package com.example.newlogindemo.model;

import java.util.Objects;

public class Student {
    private int rollNumber;
    private String name;
    private String username;
    private String email;
    private String password;

    public Student(int rollNumber, String name, String username, String email, String password) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNumber == student.rollNumber && Objects.equals(name, student.name) && Objects.equals(username, student.username) && Objects.equals(email, student.email) && Objects.equals(password, student.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNumber, name, username, email, password);
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber=" + rollNumber +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}