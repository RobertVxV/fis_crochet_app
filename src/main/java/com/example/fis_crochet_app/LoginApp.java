package com.example.fis_crochet_app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        //stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApp.class.getResource("login_page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Crochet Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}