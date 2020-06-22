package datalayer.dao;

import datalayer.dto.DatabasePlaceholder;
import datalayer.dto.ListDTO;
import datalayer.dto.TodoDTO;

import java.util.ArrayList;

public class TodoDAO
{
    public ArrayList<TodoDTO> getAllTodosOfList(ListDTO listDTO) {
        DatabasePlaceholder databasePlaceholder = DatabasePlaceholder.getInstance();
        ListDTO selectedList = databasePlaceholder.getListById(listDTO);
        ArrayList<TodoDTO> todos = selectedList.getTodos();
        return todos;
    }

    public void addTodo(ListDTO list, TodoDTO todo) {
        DatabasePlaceholder databasePlaceholder = DatabasePlaceholder.getInstance();
        databasePlaceholder.getListById(list);
        databasePlaceholder.addTodoToList(list, todo);
    }

    public void deleteTodo(ListDTO list, TodoDTO todoDTO) {
        DatabasePlaceholder databasePlaceholder = DatabasePlaceholder.getInstance();
        ListDTO dbList = databasePlaceholder.getListById(list);
        dbList.getTodos().remove(todoDTO);
    }
}