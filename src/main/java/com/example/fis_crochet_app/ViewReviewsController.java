package com.example.fis_crochet_app;

import com.example.fis_crochet_app.model.Design;
import com.example.fis_crochet_app.model.EditableDesign;
import com.example.fis_crochet_app.model.Review;
import com.example.fis_crochet_app.services.ReviewService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class ViewReviewsController extends Application {
    Color lightPurple = Color.rgb(255, 204, 255);
    Color darkPurple = Color.rgb(153, 0, 153);
    BackgroundFill backgroundFill = new BackgroundFill(lightPurple, null, null);

    Background background = new Background(backgroundFill);
    private Parent root;
    private Stage stage;
    private Scene scene;
    public static Design design;

    @FXML
    private Label title;

    @FXML
    private TableColumn reviewColumn;
    @FXML
    private TableView<EditableDesign> ViewReviews ;


    @Override
    public void start(Stage primaryStage) throws Exception {}
    @FXML
    public void initialize() {
        title.setText("View reviews for " + design.getName());
        reviewColumn.setCellValueFactory(new PropertyValueFactory<EditableDesign, Button>("Edit"));


        ArrayList<Review> arr = ReviewService.findReview(design.getName());
        for(Review r : arr)
        {
            System.out.println(r.getReview());
            addReviewToView(r);
        }
    }
    @FXML
    protected void handleBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("view_design.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    private void addReviewToView(Review r)
    {
        Button b = new Button(r.getUser() +": "+r.getReview());
        b.setAlignment(Pos.CENTER);
        b.setPrefWidth(500);
        b.setBackground(background);
        ViewReviews.getItems().add(new EditableDesign(r.getUser() +": "+r.getReview(), b));
    }
}
