module com.example.newlogindemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jakarta.persistence;


    opens com.example.newlogindemo to javafx.fxml;
    exports com.example.newlogindemo;
    exports com.example.newlogindemo.controller;
    opens com.example.newlogindemo.controller to javafx.fxml;
}