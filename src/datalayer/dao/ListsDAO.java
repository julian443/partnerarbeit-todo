package datalayer.dao;

import datalayer.dto.DatabasePlaceholder;
import datalayer.dto.ListDTO;
import datalayer.dto.TodoDTO;

import java.util.ArrayList;

public class ListsDAO {

    public ArrayList<ListDTO> getAllLists() {
        DatabasePlaceholder databasePlaceholder = new DatabasePlaceholder();
        return databasePlaceholder.getLists();
    }

    public void addList(ListDTO list) {
        DatabasePlaceholder databasePlaceholder = new DatabasePlaceholder();
        databasePlaceholder.addList(list);
    }

    public void deleteList(ListDTO list) {
        DatabasePlaceholder databasePlaceholder = new DatabasePlaceholder();
        databasePlaceholder.deleteList(list);
    }

}
