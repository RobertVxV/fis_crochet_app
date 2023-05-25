package com.example.fis_crochet_app;

import com.example.fis_crochet_app.model.Stitch;
import com.example.fis_crochet_app.services.DesignService;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

;
public class StitchListController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableView<Stitch> StitchList ;

    @FXML
    private TableColumn nameColumn ;
    @FXML
    private TableColumn abbrColumn ;
    @FXML
    private TableColumn descriptionColumn ;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1)
    {
        abbrColumn.setCellValueFactory(new PropertyValueFactory<Stitch, String>("Abbr"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Stitch, String>("Name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Stitch, String>("Description"));
        for(Stitch s :DesignService.Stitches() )
        StitchList.getItems().add(s);

    }
    @FXML
    private Button Back ;

    @FXML
    protected void handleBackToDesignActions (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("design_making.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
