package com.example.fis_crochet_app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.fis_crochet_app.LoginController.*;

public class LoginPage extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        //stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("login_page_layout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Crochet Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}