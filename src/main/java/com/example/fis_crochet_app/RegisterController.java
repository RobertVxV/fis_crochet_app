package com.example.fis_crochet_app;

import com.example.fis_crochet_app.exceptions.UsernameAlreadyExistsException;
import com.example.fis_crochet_app.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

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

                try {
                    UserService.addUser(
                            usernameTextField.getText(), emailTextField.getText(),
                            passwordField.getText()
                    );
                    registerMessageLabel.setTextFill(Color.GREEN);
                    registerMessageLabel.setText("Cont creat cu succes!\nVa puteti autentifica acum.");

                } catch (UsernameAlreadyExistsException e1) {
                    registerMessageLabel.setText(e1.getMessage());
                }

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
        root = FXMLLoader.load(getClass().getResource("login_page.fxml"));
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