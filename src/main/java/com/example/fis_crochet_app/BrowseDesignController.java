package com.example.fis_crochet_app;

import com.example.fis_crochet_app.model.Design;
import com.example.fis_crochet_app.model.EditableDesign;
import com.example.fis_crochet_app.services.DesignService;
import com.example.fis_crochet_app.services.UserService;
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
import java.util.ArrayList;
import java.util.Comparator;
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
    private CheckBox paidCheckBox;
    @FXML
    private Button searchButton;
    @FXML
    private TextField searchTextField;
    @FXML
    private TableView<EditableDesign> BrowseDesigns ;

    private ArrayList<Design> tempDesign = new ArrayList<Design>();

    @FXML
    private TableColumn editColumn ;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1)
    {
        sortingOptionBox.getItems().addAll(sortingOptions);
        editColumn.setCellValueFactory(new PropertyValueFactory<EditableDesign, Button>("Edit"));
        handleSearchActions();
    }
    @FXML
    private Button Back ;
    private void addDesignToTableView(Design d)
    {
        Button b = new Button(d.getName());
        b.setAlignment(Pos.CENTER);
        b.setPrefWidth(500);
        b.setBackground(background);
        b.setOnAction(event1 -> {
            try {
                handleViewActions(b, event1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        BrowseDesigns.getItems().add(new EditableDesign(d.getName(), b));
    }
    private void populateFilterArrayList(ArrayList<Design> arrayList)
    {
        for(Design d : DesignService.getDesignRepo().find()) {
            if(beginnerCheckBox.isSelected() && d.getDifficulty().equals("Beginner")){
                arrayList.add(d);

            }
            if(intermediateCheckBox.isSelected() && d.getDifficulty().equals("Intermediate")){
                arrayList.add(d);
            }
            if(advancedCheckBox.isSelected() && d.getDifficulty().equals("Advanced")){
                arrayList.add(d);
            }

            if(freeCheckBox.isSelected() == paidCheckBox.isSelected())
            {
                //do nothing - shows all queries
            }
            else
            {
                if (freeCheckBox.isSelected() && !d.isFree()) {
                    arrayList.remove(d);
                }
                if (paidCheckBox.isSelected() && d.isFree()) {
                    arrayList.remove(d);
                }
            }
            if(!d.getName().contains(searchTextField.getText()))
            {
                arrayList.remove(d);
            }
            if(!d.isPublic())
            {
                if(!d.getOwnerUsername().equals(UserService.get_logged_in()))
                {
                    arrayList.remove(d); //if not public and not owner by current used, remove from view
                }
            }
        }
    }
    private int difficultyOrder(String s1, String s2){
        if(s1.equals("Beginner") && s2.equals("Intermediate")) return -1;
        if(s1.equals("Intermediate") && s2.equals("Advanced")) return -1;
        return 1;
    }

    private void sortFunction(ArrayList<Design> arrayList, String criteria)
    {
        if(criteria == null) return;
        switch (criteria) {
            case "Name" -> arrayList.sort(Comparator.comparing(Design::getName));
            case "Difficulty" -> arrayList.sort((d1,d2) -> difficultyOrder(d1.getDifficulty(), d2.getDifficulty()));
            case "Price" -> arrayList.sort(Comparator.comparing(Design::getPrice));
        }
    }
    @FXML
    protected void handleSearchActions()
    {
        BrowseDesigns.getItems().clear();
        tempDesign.clear();
        populateFilterArrayList(tempDesign);
        sortFunction(tempDesign, sortingOptionBox.getValue());
        for(Design d : tempDesign) {
            addDesignToTableView(d);
        }
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

