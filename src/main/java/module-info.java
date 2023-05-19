module com.example.fis_crochet_app {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fis_crochet_app to javafx.fxml;
    exports com.example.fis_crochet_app;

    opens main_page_GUI to javafx.fxml;
    exports main_page_GUI;


}

