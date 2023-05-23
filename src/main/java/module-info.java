module com.example.fis_crochet_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires nitrite;
    requires com.fasterxml.jackson.databind;


    opens com.example.fis_crochet_app to javafx.fxml;
    exports com.example.fis_crochet_app;
    exports com.example.fis_crochet_app.model;
    opens com.example.fis_crochet_app.model to com.fasterxml.jackson.databind, javafx.fxml;
}

