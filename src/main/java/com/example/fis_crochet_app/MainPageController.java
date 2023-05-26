package com.example.fis_crochet_app;

import com.example.fis_crochet_app.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class MainPageController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button My_Creations ;
    @FXML
    private Button New_Creation ;
    @FXML
    private Button Browse_Designs ;
    @FXML
    private Button Liked_Designs ;
    @FXML
    private Button logoutButton;
    @FXML
    private Label welcomeText;


    @FXML
    protected void handleMyCreationsActions (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("my_design.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void handleNewCreationActions (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("new_design_entrance.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void handleBrowseDesignsActions () {
        welcomeText.setText("Welcome to BrowseDesigns!");
    }
    @FXML
    protected void handleLikedDesignsActions(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("liked_designs.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void openLoginPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login_page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void handleExitActions (ActionEvent event) throws IOException {
        UserService.logout();
        openLoginPage(event);
    }
}