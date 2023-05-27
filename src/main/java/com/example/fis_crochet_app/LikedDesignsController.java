package com.example.fis_crochet_app;

import com.example.fis_crochet_app.model.Design;
import com.example.fis_crochet_app.model.EditableDesign;
import com.example.fis_crochet_app.model.Stitch;
import com.example.fis_crochet_app.services.DesignService;
import com.example.fis_crochet_app.services.UserService;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

;

public class LikedDesignsController implements Initializable {

    Color lightPurple = Color.rgb(255, 204, 255);
    Color darkPurple = Color.rgb(153, 0, 153);
    BackgroundFill backgroundFill = new BackgroundFill(lightPurple, null, null);

    Background background = new Background(backgroundFill);
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableView<EditableDesign> MyDesigns;

    @FXML
    private TableColumn editColumn;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        editColumn.setCellValueFactory(new PropertyValueFactory<EditableDesign, Button>("Edit"));
        ArrayList<Design> likedDesigns = UserService.get_logged_in().getLikedDesigns();
        for (Design d : likedDesigns) {
            Button b = new Button(d.getName());
            b.setAlignment(Pos.CENTER);
            b.setPrefWidth(500);
            b.setBackground(background);
            b.setOnAction(event -> {
                try {
                    handleViewActions(b, event);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            MyDesigns.getItems().add(new EditableDesign(d.getName(), b));
        }

    }

    @FXML
    private Button Back;

    @FXML
    protected void handleViewActions(Button b, ActionEvent event) throws IOException {
        DesignService.setCurrentDesign(b.getText());
        root = FXMLLoader.load(getClass().getResource("view_design.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void handleBackToMenuActions(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("main_page.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
