package controllers;

import datalayer.dao.LoginDAO;
import datalayer.dto.UserDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;


import javax.management.PersistentMBean;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    TextField username;

    @FXML
    TextField pw;

    @FXML
    Label fieldsNotValid;

    public Button submitAcc;

    private LoginController Loader;

    LoginDAO loginDAO;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fieldsNotValid.setVisible(false);
    }

    public void Submit(javafx.event.ActionEvent actionEvent) {
/*
        ArrayList<UserDTO> users = loginDAO.getAllUsers();


        for (UserDTO user : users) {
            if (user.getUsername().equals(username.getText())) {
                fieldsNotValid.setVisible(true);
            }
        }
*/
        if (username.getText().trim().length() == 0 || pw.getText().trim().length() == 0) {
            fieldsNotValid.setVisible(true);
        } else {

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
}
