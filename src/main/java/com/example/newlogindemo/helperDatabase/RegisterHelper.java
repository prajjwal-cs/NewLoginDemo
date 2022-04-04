/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 03-04-2022
Time: 01:10
File: RegisterHelper.java 

*/

package com.example.newlogindemo.helperDatabase;

import com.example.newlogindemo.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterHelper {

    public void createStudent(Connection connection, Student student) throws SQLException {
        String insertQuery =
                "INSERT INTO studentinfo (rollNumber, studentName, username, email, password) values (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.setInt(1, student.getRollNumber());
        statement.setString(2, student.getStudentName());
        statement.setString(3, student.getUsername());
        statement.setString(4, student.getEmail());
        statement.setString(5, student.getPassword());

        statement.execute();
    }
}