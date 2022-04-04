/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 04-04-2022
Time: 23:47
File: LoginHelper.java 

*/

package com.example.newlogindemo.helperDatabase;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginHelper {
    public void loginStudent(Connection connection, String username, String password) throws SQLException {
        // login Query
        String LoginQuery = "SELECT * FROM studentinfo WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(LoginQuery);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        preparedStatement.execute();
    }
}