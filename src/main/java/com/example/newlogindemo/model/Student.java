/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 05-04-2022
Time: 00:26
File: Studentinfo.java 

*/

package com.example.newlogindemo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "rollNumber")
    private int rollNumber;
    @Basic
    @Column(name = "studentName")
    private String studentName;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;

    public Student(int rollNumber, String name, String username, String email, String password) {
        this.rollNumber = rollNumber;
        this.studentName = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Student() {

    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

        Student that = (Student) o;

        if (rollNumber != that.rollNumber) return false;
        if (!Objects.equals(studentName, that.studentName)) return false;
        if (!Objects.equals(username, that.username)) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(password, that.password)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rollNumber;
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Studentinfo{" +
                "rollNumber=" + rollNumber +
                ", studentName='" + studentName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}