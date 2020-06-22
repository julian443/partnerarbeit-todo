package datalayer.dao;

import datalayer.dto.DatabasePlaceholder;
import datalayer.dto.ListDTO;
import datalayer.dto.TodoDTO;

import java.util.ArrayList;

public class ListsDAO {

    public ArrayList<ListDTO> getAllLists() {
        DatabasePlaceholder databasePlaceholder = DatabasePlaceholder.getInstance();
        return databasePlaceholder.getLists();
    }

    public void addList(ListDTO list) {
        DatabasePlaceholder databasePlaceholder = DatabasePlaceholder.getInstance();
        databasePlaceholder.addList(list);
    }

    public void deleteList(ListDTO list) {
        DatabasePlaceholder databasePlaceholder = DatabasePlaceholder.getInstance();
        databasePlaceholder.deleteList(list);
    }

}
