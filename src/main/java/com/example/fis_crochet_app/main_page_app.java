package com.example.fis_crochet_app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
public class main_page_app extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main_page.fxml"));
        primaryStage.setTitle("Main Page");
        Scene s = new Scene(root, 500, 800);
        s.setFill(new RadialGradient(
                0, 0, 0, 0, 1, true,                  //sizing
                CycleMethod.NO_CYCLE,                 //cycling
                new Stop(0, Color.web("#F2C1E6")),    //colors
                new Stop(1, Color.web( "#A63C95")))
        );
        primaryStage.setScene(s);
        primaryStage.show();
    }

    public static void main(String[] args) {
        System.setProperty("prism.verbose", "true");
        System.setProperty("prism.debug", "true");
        launch(args);
    }
}
