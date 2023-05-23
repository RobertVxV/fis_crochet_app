package com.example.fis_crochet_app;

import com.example.fis_crochet_app.exceptions.DesignAlreadyExists;
import com.example.fis_crochet_app.services.DesignService;
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
import javafx.scene.paint.Paint;
import org.dizitart.no2.exceptions.ErrorMessage;

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
            } catch(DesignAlreadyExists e1)
            {
                Error_Message.setTextFill(Color.RED);
                Error_Message.setText(e1.getMessage())
                ;
            }
       /*
       StringBuilder sb = new StringBuilder();
       sb.append(Design_Name.getText().toString() + " ");
        sb.append(Description.getText().toString() + "\n");
        //File file = new File("src/main/resources/Designs") ;
        FileWriter W = new FileWriter("src/main/resources/Designs", true);
        W.write(Id + " ");
        W.write(sb.toString());
        W.close();*/
            root = FXMLLoader.load(getClass().getResource("design_making.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            Error_Message.setText("Please fill the form");
        }
    }
}
