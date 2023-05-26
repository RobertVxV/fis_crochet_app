package com.example.fis_crochet_app;

import com.example.fis_crochet_app.model.Design;
import com.example.fis_crochet_app.model.Row;
import com.example.fis_crochet_app.model.Stitch;
import com.example.fis_crochet_app.services.DesignService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

;
public class DesignMakingController implements Initializable {


    private Stage stage;
    private Scene scene;
    private Parent root;
    private Row row = new Row();
    private String text = new String();
    @FXML
    private VBox Vbox = new VBox();
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
    private ScrollPane DesignPane;
    @FXML
    public void initialize(URL arg0, ResourceBundle arg1) {
        for(Object o : DesignService.Items() )
        {
            if (o instanceof byte[])
            {
                Image image = new Image(new ByteArrayInputStream((byte[]) o));
                ImageView imageView = new ImageView(image);
                imageView.prefWidth(200);
                imageView.prefHeight(200);
                imageView.setFitWidth(200);
                imageView.setFitHeight(200);
                Vbox.getChildren().add(imageView);
            }
            else
            {
                Label l = new Label(o.toString());
                Vbox.getChildren().add(l);
            }

        }
        DesignPane.setContent(Vbox);

    }

    @FXML
    protected void handleEditActions (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("edit_design.fxml"));
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

    @FXML
    protected void handleAddRowActions (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("add_row.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void handleAddTextActions (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("add_text.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void handleAddPhotoActions (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("add_photo.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
