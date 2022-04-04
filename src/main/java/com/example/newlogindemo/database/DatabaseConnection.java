/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 01-04-2022
Time: 00:31
File: DatabaseConnection.java 

*/

package com.example.newlogindemo.database;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private final String URL = "jdbc:mysql://localhost:3306/students";
    private final String USERNAME = "root";
    private final String PASSWORD = "";

    private Connection connection = null;

    public Connection getConnection() {
        return connection;
    }

    public boolean createConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection != null;
    }

    public void printConnectionStatus() {
        if (getConnection() != null) {
            printSuccess();
        } else {
            printConnectionInActive();
        }
    }

    public void printSuccess() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Data inserted successfully!");
        alert.setTitle("ONLINE");
        alert.show();
    }

    public void printConnectionInActive() {
        try {
            String userName = getConnection().getMetaData().getUserName();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Hi, " + userName + " sorry, we could not connect to the database!" +
                    "Please check your username, password and url.");
            alert.setTitle("OFFLINE");
            alert.show();
        } catch (SQLException ignored) {

        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}