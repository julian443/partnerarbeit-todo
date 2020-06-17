package logiclayer;

import datalayer.dto.ListDTO;
import datalayer.dto.TodoDTO;

import java.util.ArrayList;

public interface MinimalistFunctions {

    public void addTodo(TodoDTO todoDTO, ListDTO listDTO);

    public void deleteTodo(ListDTO listDTO, TodoDTO todoDTO);

    public void editTodo(TodoDTO todoDTO, int listId);

    public void addList(ListDTO list);

    public void deleteList(int todoId, int listId);

}
