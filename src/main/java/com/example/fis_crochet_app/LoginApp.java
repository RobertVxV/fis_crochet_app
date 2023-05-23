package com.example.fis_crochet_app;

import com.example.fis_crochet_app.services.DesignService;
import com.example.fis_crochet_app.services.FileSystemService;
import com.example.fis_crochet_app.services.DesignFileSystemService;
import com.example.fis_crochet_app.services.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LoginApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        initDirectory();
        initDesignDirectory();
        FileSystemService.initDatabase();
        DesignFileSystemService.initDesignDatabase();
        UserService.init();
        DesignService.init();

        //stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApp.class.getResource("login_page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Crochet Application");
        stage.setScene(scene);
        stage.show();
    }

    private void initDirectory() {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }
    private void initDesignDirectory() {
        Path applicationHomePath = DesignFileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }
    public static void main(String[] args) {
        launch();
    }
}