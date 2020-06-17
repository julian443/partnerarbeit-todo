package logiclayer;

import datalayer.dao.ListsDAO;
import datalayer.dao.TodoDAO;
import datalayer.dto.ListDTO;
import datalayer.dto.TodoDTO;

import java.util.ArrayList;

public class Minimalist implements MinimalistFunctions {

    private ListsDAO listsDAO;

    private TodoDAO todoDAO;

    // TODO FUNCTIONS

    public void addTodo(TodoDTO todoDTO, ListDTO listDTO) {
        todoDAO.addTodo(listDTO, todoDTO);
    }

    public void deleteTodo(ListDTO listDTO, TodoDTO todoDTO) {
        todoDAO.deleteTodo(listDTO, todoDTO);
    }

    public void editTodo(TodoDTO todoDTO, int listId) {

    }

    // LIST FUNCTIONS

    public void addList(ListDTO list) {
        listsDAO.addList(list);
    }

    public void deleteList(int todoId, int listId) {
        ArrayList<ListDTO> allLists = listsDAO.getAllLists();
        for (ListDTO list : allLists) {
            if (list.getId() == todoId) {
                listsDAO.deleteList(list);
            }
        }
    }

}
