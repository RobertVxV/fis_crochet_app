package com.example.fis_crochet_app;

import com.example.fis_crochet_app.model.Row;
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
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

import static com.example.fis_crochet_app.services.DesignService.addStitchToDesign;

public class AddRowController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField Row;

    @FXML
    private Button Submit ;
    @FXML
    private Button Cancel ;

    @FXML
    private Label Error_Label;

    @FXML
    protected void handleSubmitActions (ActionEvent event) throws IOException{
        if (Row.getText().isBlank() == false ) {
            //|| Character.compare(Row.getText().charAt(0), ' ') != 0
            Row r = new Row(Row.getText());
            r.setTotalStitches(r.calculateTotalStitches(DesignService.Stitches()));
            DesignService.addRowToDesign(r);
            root = FXMLLoader.load(getClass().getResource("design_making.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            Error_Label.setText("Please add a valid row");
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
