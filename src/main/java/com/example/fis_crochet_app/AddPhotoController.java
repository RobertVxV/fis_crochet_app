package com.example.fis_crochet_app;

import com.example.fis_crochet_app.services.DesignService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritablePixelFormat;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class AddPhotoController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField Photo;

    @FXML
    private Button Submit;
    @FXML
    private Button Cancel;

    @FXML
    protected void handleSubmitActions(ActionEvent event) throws IOException {
        Image myImage = new Image(getClass().getResourceAsStream("fluturee.jpeg"));
        byte[] imageBytes = imageToBytes(myImage);
        DesignService.addPhotoToDesign(imageBytes);
        root = FXMLLoader.load(getClass().getResource("design_making.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void handleCancelActions(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("design_making.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private byte[] imageToBytes(Image image) {
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        PixelReader pixelReader = image.getPixelReader();
        WritablePixelFormat<ByteBuffer> pixelFormat = WritablePixelFormat.getByteBgraInstance();

        ByteBuffer buffer = ByteBuffer.allocate(width * height * 4);
        pixelReader.getPixels(0, 0, width, height, pixelFormat, buffer, width * 4);

        byte[] imageBytes = new byte[buffer.capacity()];
        buffer.get(imageBytes);
        return imageBytes;
    }
}

