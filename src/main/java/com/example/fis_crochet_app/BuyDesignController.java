package com.example.fis_crochet_app;

import com.example.fis_crochet_app.model.Design;
import com.example.fis_crochet_app.services.UserService;
import com.example.fis_crochet_app.services.VoucherService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.example.fis_crochet_app.model.Voucher;


import java.io.IOException;
import java.util.ArrayList;

public class BuyDesignController extends Application {


    private Stage stage;
    private Scene scene;
    private Parent root;

    public static Design design;
    @FXML
    private Label title;

    @FXML
    private TextField Card_Number;

    @FXML
    private TextField Month;

    @FXML
    private TextField Year;

    @FXML
    private TextField Name;

    @FXML
    private TextField CVV;

    @FXML
    private TextField Voucher_cod;

    @FXML
    private Label Error_Message;

    private Stage s;


    public static void main(String[] args) {

        launch();
    }
    @Override
    public void start(Stage s){
        this.s = s;
    }
    @FXML
    public void initialize() {
        System.out.println("aasdnaskld");
        title.setText("Buy design " + design.getName());
        if(design.isFree()){
            UserService.get_logged_in().addDesign(design.getName());
            UserService.updateUser(UserService.get_logged_in());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thank you for the purchase!");
            alert.show();

            try {
                root = FXMLLoader.load(getClass().getResource("main_page.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage = s;
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
    }
    @FXML
    protected void goBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("view_design.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    } @FXML
    protected void handleSubmitAction(ActionEvent event) throws IOException {
        String numar = Card_Number.getText();
        String  luna = Month.getText();
        String an = Year.getText();
        String nume = Name.getText();
        String cvv = CVV.getText();
        String voucher = Voucher_cod.getText();

        if(voucher.length()==0) {
            try {
                if (nume.length() == 0)
                    throw new NumberFormatException();
                else
                    System.out.println("nume ok");

                if (numar.length() == 16) {
                    System.out.println(Long.parseUnsignedLong(numar));
                    System.out.println("card ok");
                } else
                    throw new NumberFormatException();

                if (luna.length() == 2 || luna.length() == 1) {
                    int l = Integer.parseInt(luna);
                    if(l<1 || l > 12)
                        throw new NumberFormatException();
                    System.out.println("lna ok");
                } else
                    throw new NumberFormatException();

                if (an.length() == 4) {
                    int l = Integer.parseInt(an);
                    if(l<2023 || l > 2030)
                        throw new NumberFormatException();

                    System.out.println("an ok");
                } else
                    throw new NumberFormatException();

                if (cvv.length() == 3) {
                    Integer.parseInt(cvv);
                    System.out.println("cvv ok");
                } else
                    throw new NumberFormatException();
            } catch (NumberFormatException e) {
                Error_Message.setText("Card details are invalid");
                return;
            }
        }
        else{
            Voucher v = VoucherService.findVoucher(voucher);
            if(v == null){
                Error_Message.setText("Invalid voucher");
                return;
            }else if(v.getValoare() < design.getPrice()){

                Error_Message.setText("Not enough funds");
                return;
            }else{
                VoucherService.deleteVoucher(v.getCod());
            }
        }
        UserService.get_logged_in().addDesign(design.getName());
        UserService.updateUser(UserService.get_logged_in());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thank you for the purchase!");
        alert.show();

        root = FXMLLoader.load(getClass().getResource("main_page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
