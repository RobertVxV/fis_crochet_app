package com.example.fis_crochet_app;

import com.example.fis_crochet_app.model.Design;
import com.example.fis_crochet_app.model.EditableDesign;
import com.example.fis_crochet_app.services.DesignService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

;

public class BrowseDesignController implements Initializable {


    Color lightPurple = Color.rgb(255, 204, 255);
    Color darkPurple = Color.rgb(153, 0, 153);
    BackgroundFill backgroundFill = new BackgroundFill(lightPurple, null, null);

    Background background = new Background(backgroundFill);
    private Stage stage;
    private Scene scene;
    private Parent root;

    private String[] sortingOptions= {"Name", "Difficulty", "Price"};
    @FXML
    private ChoiceBox<String> sortingOptionBox = new ChoiceBox(FXCollections.observableArrayList(sortingOptions));
    @FXML
    private CheckBox beginnerCheckBox;
    @FXML
    private CheckBox intermediateCheckBox;
    @FXML
    private CheckBox advancedCheckBox;
    @FXML
    private CheckBox freeCheckBox;
    @FXML
    private CheckBox notFreeCheckBox;
    @FXML
    private TableView<EditableDesign> BrowseDesigns ;

    @FXML
    private TableColumn editColumn ;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1)
    {
        editColumn.setCellValueFactory(new PropertyValueFactory<EditableDesign, Button>("Edit"));
        for(Design d : DesignService.getDesignRepo().find()) {
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
            BrowseDesigns.getItems().add(new EditableDesign(d.getName(), b));
        }
    }
    @FXML
    private Button Back ;
    @FXML
    protected void handlePriceFilter(ActionEvent event)
    {
        //for(Design d : DesignService.getDesignRepo().find()) {
    }
    @FXML
    protected void handleViewActions (Button b, ActionEvent event) throws IOException{
        DesignService.setCurrentDesign(b.getText());
        root = FXMLLoader.load(getClass().getResource("view_design.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void handleBackToMenuActions (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("main_page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

