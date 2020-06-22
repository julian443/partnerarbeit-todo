package controllers;

import datalayer.dao.TodoDAO;
import datalayer.dto.ListDTO;
import datalayer.dto.TodoDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CreateTodoController implements Initializable
{
    public Button createTodo;
    public TextField textfield;
    public DatePicker datePicker;
    public ComboBox urgencyDropdown;
    ListDTO list;

    public CreateTodoController(ListDTO list)
    {
        this.list = list;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createTodo.setOnAction(new EventHandler<ActionEvent>()
                {
        @Override public void handle(ActionEvent e)
        {
            int urgency = (Integer) urgencyDropdown.getValue();
            LocalDate localDate = datePicker.getValue();
            TodoDTO task = new TodoDTO(3, textfield.getText(), String.valueOf(localDate), urgency);
            TodoDAO dao = new TodoDAO();
            dao.addTodo(list, task);
            Stage stage;
            Parent root = null;

            stage = (Stage) createTodo.getScene().getWindow();

            try {
                root = FXMLLoader.load(this.getClass().getResource("../views/MainView.fxml"));
            } catch (IOException es) {
                es.printStackTrace();
            }

            Scene scene = new Scene(root);
            stage.setTitle("MinimaList");
            stage.setScene(scene);
            stage.show();
        }
        });
        ObservableList<Integer> lUrgency = FXCollections.observableArrayList(1,2,3,4,5);
        urgencyDropdown.setItems(lUrgency);
    }


}
