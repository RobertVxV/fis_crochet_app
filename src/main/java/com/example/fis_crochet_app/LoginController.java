package com.example.fis_crochet_app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    public void onLoginButtonClick(ActionEvent e){


        if(usernameTextField.getText().isBlank() == false && passwordField.getText().isBlank() == false) {
            loginMessageLabel.setText("You tried to login.");
        }
        else {
            loginMessageLabel.setText("Please enter username and password.");
        }
    }
}