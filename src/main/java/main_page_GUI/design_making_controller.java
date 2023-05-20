package main_page_GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;;
import javafx.scene.control.ChoiceBox;
import javafx.collections.*;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.io.*;
public class design_making_controller {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button Edit_Button ;
    @FXML
    private Button Stitch_Adder ;
    @FXML
    private Button Stitch_Lists ;
    @FXML
    private Button Add_Text ;
    @FXML
    private Button Add_Row ;
    @FXML
    private Button Add_Photo ;
    @FXML
    private Button Save_Exit ;

    @FXML
    protected void handleEditActions (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("new_design_entrance.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void handleSaveExitActions (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("main_page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void handleAddStitchActions (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("add_stitch.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void handleStitchListActions (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("stitch_list.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
