package com.example.fis_crochet_app;

import com.example.fis_crochet_app.model.Design;

import com.example.fis_crochet_app.model.User;
import com.example.fis_crochet_app.services.DesignService;
import com.example.fis_crochet_app.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import java.util.ResourceBundle;

public class ViewDesignController implements Initializable {


    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button Buy_design;
    @FXML
    private Button Like_Design;
    @FXML
    private Button Edit;
    @FXML
    private Button Back;
    @FXML
    private ScrollPane Rows;
    @FXML
    private Label DescriptionLabel;
    @FXML
    private Label TitleLabel;
    @FXML
    private Label OwnerLabel;
    @FXML
    private Label DifficultyLabel;
    @FXML
    private Label PriceLabel;
    @FXML
    private Label likesLabel;

    @FXML
    private VBox Vbox = new VBox();

    @FXML
    public void initialize(URL arg0, ResourceBundle arg1) {
        TitleLabel.setText(DesignService.get_current_design().getName());
        DifficultyLabel.setText(DesignService.get_current_design().getDifficulty());
        OwnerLabel.setText(DesignService.get_current_design().getOwnerUsername());
        DescriptionLabel.setText(DesignService.get_current_design().getDescription());
        PriceLabel.setText(DesignService.getDesignPrice().toString());
        likesLabel.setText(String.valueOf(DesignService.get_current_design().getLikes()));
        boolean userBoughtThisDesign = false;
        for (String s : UserService.get_logged_in().getDesignuri_cumparate())
            if (DesignService.getDesignName().equals(s))
                userBoughtThisDesign = true;

        if (DesignService.get_current_design().isFree() || UserService.get_logged_in().getUsername().equals(DesignService.get_current_design().getOwnerUsername()) || userBoughtThisDesign) {

            for (Object o : DesignService.Items()) {
                if (o instanceof byte[]) {
                    Image image = new Image(new ByteArrayInputStream((byte[]) o));
                    ImageView imageView = new ImageView(image);
                    imageView.prefWidth(200);
                    imageView.prefHeight(200);
                    imageView.setFitWidth(200);
                    imageView.setFitHeight(200);
                    Vbox.getChildren().add(imageView);
                } else {
                    Label l = new Label(o.toString());
                    Vbox.getChildren().add(l);
                }

            }
            Rows.setContent(Vbox);

        } else {
            PriceLabel.setText(DesignService.getDesignPrice().toString());
            Label l = new Label("Only available for buyers");
            Vbox.getChildren().add(l);
            Rows.setContent(Vbox);
        }
        if (UserService.get_logged_in().getLikedDesigns().contains(DesignService.get_current_design())) {
            Like_Design.setText("Unlike");
        }
    }

    @FXML
    protected void handleLikeAction() {
        Design current_design = DesignService.get_current_design();
        User logged_in_user = UserService.get_logged_in();

        if (logged_in_user.getLikedDesigns().contains(current_design)) {
            logged_in_user.removeLikedDesign(current_design);
            Like_Design.setText("Like");
        } else {
            logged_in_user.addLikedDesign(current_design);
            Like_Design.setText("Unlike");
        }
    }

    @FXML
    protected void goToBuy(ActionEvent event) throws IOException {
        boolean userBoughtThisDesign = false;
        for (String s : UserService.get_logged_in().getDesignuri_cumparate())
            if (DesignService.getDesignName().equals(s))
                userBoughtThisDesign = true;
        if (!userBoughtThisDesign) {
            BuyDesignController.design = DesignService.get_current_design();
            root = FXMLLoader.load(getClass().getResource("buy_design.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Register Confirmation");
            alert.setContentText("You already bought this design!");
            alert.show();
        }
    }

    @FXML
    protected void handleEditActions(ActionEvent event) throws IOException {
        if (UserService.get_logged_in().getUsername().equals(DesignService.get_current_design().getOwnerUsername())) {
            root = FXMLLoader.load(getClass().getResource("design_making.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Register Confirmation");
            alert.setContentText("Only the owner can edit this design!");
            alert.show();
        }

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
