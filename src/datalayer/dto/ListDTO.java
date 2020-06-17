package datalayer.dto;

import java.util.ArrayList;

public class ListDTO {

    private int id;

    private String name;

    private ArrayList<TodoDTO> todos;


    public ListDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ListDTO(int id, String name, ArrayList<TodoDTO> todos) {
        this.id = id;
        this.name = name;
        this.todos = todos;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<TodoDTO> getTodos() {
        return todos;
    }

    public void setTodos(ArrayList<TodoDTO> todos) {
        this.todos = todos;
    }
}
