/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 01-04-2022
Time: 00:29
File: StudentController.java 

*/

package com.example.newlogindemo.controller;

import com.example.newlogindemo.HelloApplication;
import com.example.newlogindemo.database.DatabaseConnection;
import com.example.newlogindemo.helperDatabase.LoginHelper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button loginButton;

    @FXML
    private Button clickRegisterButton;


    @FXML
    protected void onLoginButtonClick() throws SQLException {
        if(usernameTextField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Username cannot be empty");
        }
        if (passwordTextField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Password cannot be empty");
        }
        isValidPassword();



    }

    private void isValidPassword() {
        final String regex = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$";
        if (!passwordTextField.getText().matches(regex)) {
            showAlert(Alert.AlertType.ERROR, "Error",
                    "Password must contain at least one digit, one upper case letter, " +
                            "one lower case letter, one special character and must be between 8 and" +
                            " 16 characters long");
        }
    }

    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
    @FXML
    protected void onRegisterButtonClick() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("register-view.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Register");
        stage.setScene(scene);
        stage.show();
        this.closeCurrentStage();
    }

    private void closeCurrentStage() {
        Stage stage = (Stage) this.clickRegisterButton.getScene().getWindow();
        stage.close();
    }

}