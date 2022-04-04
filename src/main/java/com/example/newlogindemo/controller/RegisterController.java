/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 01-04-2022
Time: 01:10
File: RegisterView.java 

*/

package com.example.newlogindemo.controller;

import com.example.newlogindemo.HelloApplication;
import com.example.newlogindemo.database.DatabaseConnection;
import com.example.newlogindemo.helperDatabase.RegisterHelper;
import com.example.newlogindemo.model.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterController {
    @FXML
    public TextField rollNumberTextField;

    @FXML
    public TextField nameTextField;

    @FXML
    public TextField usernameTextField;

    @FXML
    public TextField emailTextField;

    @FXML
    public PasswordField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private Button registerToLoginButton;

    @FXML
    protected void onRegisterButtonClick() throws SQLException {
        // Make connection to database
        DatabaseConnection connection = new DatabaseConnection();
        connection.createConnection();
        connection.printConnectionStatus();
        // Insert data into database from these fields
        int rollNumber = Integer.parseInt(rollNumberTextField.getText());
        String name = nameTextField.getText();
        String username = usernameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordField.getText();

        // Insert data into Student Object
        Student student = new Student(rollNumber, name, username, email, password);
        // Insert data into database
        RegisterHelper registerHelper = new RegisterHelper();
        registerHelper.createStudent(connection.getConnection(), student);
    }

    @FXML
    protected void onLoginButtonClick() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader  = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
        closeCurrentStage();
    }

    private void closeCurrentStage() {
        Stage stage = (Stage) registerButton.getScene().getWindow();
        stage.close();
    }
}