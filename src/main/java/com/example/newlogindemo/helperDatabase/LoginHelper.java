/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 04-04-2022
Time: 23:47
File: LoginHelper.java 

*/

package com.example.newlogindemo.helperDatabase;


import com.example.newlogindemo.database.DatabaseConnection;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginHelper {
    public boolean loginStudent(String username, String password) throws SQLException {

        DatabaseConnection databaseConnection = new DatabaseConnection();

        databaseConnection.createConnection();
        // login Query
        String LoginQuery = "SELECT * FROM studentinfo WHERE username = ? AND password = ?";
        Connection connection = databaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(LoginQuery);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next();
    }
}