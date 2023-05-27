package com.example.fis_crochet_app;

import com.example.fis_crochet_app.exceptions.DesignAlreadyExists;
import com.example.fis_crochet_app.services.DesignService;
import com.example.fis_crochet_app.model.Design;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

;

public class NewDesignEntranceController implements Initializable {

    private int Id;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label Error_Message;
    @FXML
    private CheckBox Free_Checkbox;
    @FXML
    private CheckBox Make_PublicCheckbox;
    @FXML
    private TextField Design_Name;
    @FXML
    private TextField Price_TextBox;
    @FXML
    private TextArea Description;
    private String[] Difficulties= {"Beginner", "Intermediate", "Advanced"};
    @FXML
    private ChoiceBox<String> Difficulty_Box = new ChoiceBox(FXCollections.observableArrayList(Difficulties));
    @FXML
    private Button Submit_Design_Info_Button ;

    @FXML
    private Button Exit ;
   @Override
    public void initialize(URL arg0, ResourceBundle arg1)
    {
        Difficulty_Box.getItems().addAll(Difficulties);
    }
    @FXML
    protected void handleSubmitAction (ActionEvent event) throws IOException{

        if (Difficulty_Box.getValue() != null &&
                Design_Name.getText().isBlank() == false &&
                Description.getText().isBlank() == false &&
                (Free_Checkbox.isSelected() == true || Price_TextBox.getText().isBlank() == false)) {
            try{
                DesignService.addDesign(Design_Name.getText(), Difficulty_Box.getValue(), Double.parseDouble(Price_TextBox.getText()), Description.getText(), Make_PublicCheckbox.isSelected(), Free_Checkbox.isSelected() );
                Error_Message.setTextFill(Color.GREEN);
                Error_Message.setText("Design Added Sucessfully");
                root = FXMLLoader.load(getClass().getResource("design_making.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch(DesignAlreadyExists e1)
            {
                Error_Message.setTextFill(Color.RED);
                Error_Message.setText(e1.getMessage())
                ;
            }


        }
        else
        {
            Error_Message.setTextFill(Color.RED);
            Error_Message.setText("Please fill the form");
        }
    }
    @FXML
    protected void handleExitAction(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("main_page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
