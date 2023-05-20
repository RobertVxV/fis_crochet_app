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

public class new_design_entrance_controller implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label Difficulty_Label;
    private String[] Difficulties= {"Beginner", "Intermediate", "Advanced"};
    @FXML
    private ChoiceBox<String> Difficulty_Box = new ChoiceBox(FXCollections.observableArrayList(Difficulties));
    @FXML
    private Button Submit_Design_Info_Button ;
   @Override
    public void initialize(URL arg0, ResourceBundle arg1)
    {
        Difficulty_Box.getItems().addAll(Difficulties);
    }
    @FXML
    protected void handleSubmitAction (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("design_making.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
