package com.example.fis_crochet_app;

import com.example.fis_crochet_app.model.Design;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewDesignController extends Application {


    private Stage stage;
    private Scene scene;
    private Parent root;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }
    @FXML
    protected void goToBuy(ActionEvent event) throws IOException {
        //Trebuie pus designul pe care vrei sa il cumperi
        BuyDesignController.design = new Design("Catel", "", 14.3, "", true, false);//aici vine inlocuit cu designul cumparat
        root = FXMLLoader.load(getClass().getResource("buy_design.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
