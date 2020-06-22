package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;



import javax.management.PersistentMBean;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public Button submitAcc;
    private LoginController Loader;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void Submit(javafx.event.ActionEvent actionEvent) {
        Stage stage;
        Parent root = null;

        stage = (Stage) this.submitAcc.getScene().getWindow();

        try {
            root = FXMLLoader.load(this.getClass().getResource("../views/MainView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        stage.setTitle("MinimaList");
        stage.setScene(scene);
        stage.show();
    }
}
