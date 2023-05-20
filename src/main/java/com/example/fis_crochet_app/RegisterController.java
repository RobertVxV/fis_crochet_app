package com.example.fis_crochet_app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.io.IOException;

import javafx.stage.Stage;

public class RegisterController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label registerMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField passwordField1;

    @FXML
    public void onRegisterButtonClick(ActionEvent e) throws IOException {
        if (usernameTextField.getText().isBlank() == false &&
                emailTextField.getText().isBlank() == false &&
                passwordField.getText().isBlank() == false &&
                passwordField1.getText().isBlank() == false) {

            if (passwordField.getText().equals(passwordField1.getText()) == true) {
                registerMessageLabel.setTextFill(Color.GREEN);
                registerMessageLabel.setText("You tried to register.");
                registerConfirmation(e);
                return;
            }
            else {
                registerMessageLabel.setText("Confirmation password is incorrect.");
            }
        }
        else {
            registerMessageLabel.setText("Please enter all fields above.");
        }
    }
    @FXML
    public void openLoginPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login_page_layout.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void registerConfirmation(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Register Confirmation");
        alert.setContentText("You succesfully registered, you can now login.");
        alert.show();
        openLoginPage(event);
    }
    @FXML
    public void onLoginButtonClick(ActionEvent event) throws IOException {
        openLoginPage(event);
    }
}