package main_page_GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.io.*;


public class main_page_controller {

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
    private Button Exit ;
    @FXML
    private Label welcomeText;


    @FXML
    protected void handleMyCreationsActions () {
        welcomeText.setText("Welcome to MyCreations!");
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
    protected void handleLikedDesignsActions () {
        welcomeText.setText("Welcome to LikedDesigns!");
    }
    @FXML
    protected void handleExitActions (ActionEvent event) {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }
}