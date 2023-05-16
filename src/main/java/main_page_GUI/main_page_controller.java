package main_page_GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.stage.Window;
public class main_page_controller {
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
    protected void handleNewCreationActions () {
        welcomeText.setText("Welcome to NewCreation!");
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