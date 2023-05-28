package com.example.fis_crochet_app;

import com.example.fis_crochet_app.model.Design;
import com.example.fis_crochet_app.services.ReviewService;
import com.example.fis_crochet_app.services.UserService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class AddReviewController extends Application {

    public static Design design;
    @FXML
    private Label title;
    @FXML
    private TextArea review_content;
    private Parent root;
    private Stage stage;
    private Scene scene;

    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {}
    @FXML
    public void initialize() {
        title.setText("Review " + design.getName());
    }

    @FXML
    protected void handleBackAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("view_design.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void handleSubmitAction(ActionEvent event) throws IOException{
        ReviewService.addReview(
                UserService.get_logged_in().getUsername(),
                design.getName(),
                review_content.getText()
                );
        root = FXMLLoader.load(getClass().getResource("view_design.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
