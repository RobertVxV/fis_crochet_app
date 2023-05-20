package com.example.fis_crochet_app;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import com.example.fis_crochet_app.LoginPage.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;
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
    private Button registerButton;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    public void onLoginButtonClick(ActionEvent e){


        if(usernameTextField.getText().isBlank() == false && passwordField.getText().isBlank() == false) {
            loginMessageLabel.setTextFill(Color.GREEN);
            loginMessageLabel.setText("You tried to login.");
        }
        else {
            loginMessageLabel.setText("Please enter username and password.");
        }
    }
    @FXML
    public void openRegisterPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("register_page_layout.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void onRegisterButtonClick(ActionEvent event) throws IOException {
        openRegisterPage(event);
    }
}