package controllers;

import datalayer.dao.ListsDAO;
import datalayer.dao.TodoDAO;
import datalayer.dto.DatabasePlaceholder;
import datalayer.dto.ListDTO;
import datalayer.dto.TodoDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    DatabasePlaceholder data = DatabasePlaceholder.getInstance();
    @FXML
    Button btnCreate;

    @FXML
    ListView mainList1;

    @FXML
    ListView mainList2;

    @FXML
    ListView mainList3;

    @FXML
    Label listLabel1;

    @FXML
    Label listLabel2;

    @FXML
    Label listLabel3;

    @FXML
    Button btnList1;

    @FXML
    Button btnList2;

    @FXML
    Button btnList3;

    @FXML
    Label showingTxt;

    ListDTO list = data.getList_schule();
    @FXML
    private void CreateTodos(ActionEvent event)
    {
        Stage stage;
        Parent root = null;

        stage = (Stage) btnCreate.getScene().getWindow();
        FXMLLoader loader = null;

        try {
            CreateTodoController controller = new CreateTodoController(list);
            loader = new FXMLLoader(this.getClass().getResource("../views/CreateTodo.fxml"));
            loader.setController(controller);
            root = loader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setTitle("Create Todo");
        stage.setScene(scene);
        stage.show();

    }

    public void ShowList1(ActionEvent actionEvent)
    {
        list = data.getList_schule();
        fillList();
    }

    public void SchowList2(ActionEvent actionEvent)
    {
        list = data.getList_alltag();
        fillList();
    }

    public void ShowList3(ActionEvent actionEvent) {
        list = data.getList_sonstig();
        fillList();
    }

    private void setCell(ListView list, String sType)
    {
        Callback<ListView<TodoDTO>, ListCell<TodoDTO>> factory = lv -> new ListCell<TodoDTO>() {
            @Override
            protected void updateItem(TodoDTO todo, boolean empty) {
                super.updateItem(todo, empty);
                setText(empty ? "" : sText(todo, sType));
            }
        };
        list.setCellFactory(factory);
    }

    private String sText(TodoDTO todo, String sType)
    {
        String value = null;
        switch (sType)
        {
            case "Name":
                value = todo.getText();
                break;
            case "Date":
                value = todo.getDatum();
                break;
            case "Urgency":
                value = String.valueOf(todo.getUrgency());
                break;
        }

        return value;
    }

    private void fillList()
    {
        TodoDAO dao = new TodoDAO();
        ArrayList<TodoDTO> itemlist = dao.getAllTodosOfList(list);

        ObservableList<TodoDTO> doList = FXCollections.observableArrayList(itemlist);

        mainList1.setItems(doList);
        setCell(mainList1, "Name");

        mainList2.setItems(doList);
        setCell(mainList2, "Date");

        mainList3.setItems(doList);
        setCell(mainList3, "Urgency");

        showingTxt.setText("Now showing " + String.valueOf(itemlist.size()) +" Todo's");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        list = data.getList_schule();
        fillList();
    }
}
