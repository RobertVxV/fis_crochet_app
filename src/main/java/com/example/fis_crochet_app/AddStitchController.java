package com.example.fis_crochet_app;

import com.example.fis_crochet_app.exceptions.StitchAlreadyExists;
import com.example.fis_crochet_app.model.Stitch;
import com.example.fis_crochet_app.services.DesignService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

import static com.example.fis_crochet_app.services.DesignService.addStitchToDesign;

public class AddStitchController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField Name;
    @FXML
    private TextField Abbreviation;
    @FXML
    private TextArea Description;
    @FXML
    private Label ErrorText;
    @FXML
    private Button Submit ;
    @FXML
    private Button Cancel ;

    @FXML
    protected void handleSubmitActions (ActionEvent event) throws IOException{
        if(Name.getText().isBlank() == false &&
                Abbreviation.getText().isBlank() == false &&
                Description.getText().isBlank() == false) {
            try {
                Stitch s = new Stitch(Name.getText(), Abbreviation.getText(), Description.getText());
                DesignService.addStitchToDesign(s);
                root = FXMLLoader.load(getClass().getResource("design_making.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (StitchAlreadyExists e1)
            {
                ErrorText.setTextFill(Color.RED);
                ErrorText.setText(e1.getMessage());
            }
        }
        else
        {
            ErrorText.setTextFill(Color.RED);
            ErrorText.setText("Please fill all the boxes");
        }
    }

    @FXML
    protected void handleCancelActions (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("design_making.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
