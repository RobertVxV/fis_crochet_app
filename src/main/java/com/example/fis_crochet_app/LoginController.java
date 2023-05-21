package com.example.fis_crochet_app;

import com.example.fis_crochet_app.exceptions.BadCredentials;
import com.example.fis_crochet_app.model.User;
import com.example.fis_crochet_app.services.UserService;
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
    public void openRegisterPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("register_page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void openMainPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("main_page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void onLoginButtonClick(ActionEvent e) throws IOException {


        if(usernameTextField.getText().isBlank() == false && passwordField.getText().isBlank() == false) {
            try{
                User user = UserService.login(usernameTextField.getText(), passwordField.getText());
                loginMessageLabel.setTextFill(Color.GREEN);
                loginMessageLabel.setText("Ok");
                /*if (user.getRole().equals("Client")) {
                    MainPageApp.switchScene("dashboard_client.fxml", "Dashboard client");
                } else if (user.getRole().equals("Muncitor")) {
                    MainPageApp.switchScene("dashboard_muncitor.fxml", "Dashboard muncitor");
                }*/
            }catch (BadCredentials e2){
                loginMessageLabel.setTextFill(Color.RED);
                loginMessageLabel.setText(e2.getMessage());
            }
            openMainPage(e);
        }
        else {
            loginMessageLabel.setText("Please enter username and password.");
        }
    }
    @FXML
    public void onRegisterButtonClick(ActionEvent event) throws IOException {
        openRegisterPage(event);
    }
}