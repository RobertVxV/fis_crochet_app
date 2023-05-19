package main_page_GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class new_design_entrance_app extends Application  {
        @Override
        public void start(Stage primaryStage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("new_design_entrance.fxml"));
            primaryStage.setTitle("Design Info");
            primaryStage.setScene(new Scene(root, 800, 500));
            primaryStage.show();
        }
        public static void main(String[] args) {

            System.setProperty("prism.verbose", "true");
            System.setProperty("prism.debug", "true");
            launch(args);
        }
    }

