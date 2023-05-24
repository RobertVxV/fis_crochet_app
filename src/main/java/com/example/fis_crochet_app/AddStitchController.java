package com.example.fis_crochet_app;

import com.example.fis_crochet_app.model.Stitch;
import com.example.fis_crochet_app.services.DesignService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    private Button Submit ;

    @FXML
    protected void handleSubmitActions (ActionEvent event) throws IOException{
        Stitch s = new Stitch(Name.getText(), Abbreviation.getText(), Description.getText());
        DesignService.addStitchToDesign(s);
        root = FXMLLoader.load(getClass().getResource("design_making.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
