package datalayer.dto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DatabasePlaceholder
{
    private TodoDTO todo1 = new TodoDTO(1, "Finish Java Project", "23.06.2020", 2);

    private TodoDTO todo2 = new TodoDTO(2, "Buy groceries", "16.06.2020", 2);

    private TodoDTO todo3 = new TodoDTO(3, "Pay bills", "25.06.2020", 1);

    private TodoDTO todo4 = new TodoDTO(4, "Learn for school", "17.06.2020", 1);

    private TodoDTO todo5 = new TodoDTO(5, "Create more TodoDTOs", "16.06.2020", 3);

    private TodoDTO todo6 = new TodoDTO(6, "Travel to America", "23.07.2021", 4);

    private UserDTO user1 = new UserDTO("user1", "user1pw");

    private UserDTO user2 = new UserDTO("user2", "user2pw");

    private UserDTO userAdmin = new UserDTO("admin", "adminpw");

    private ListDTO list_alltag = new ListDTO(1, "alltag");

    private ListDTO list_schule = new ListDTO(2, "schule");

    private ListDTO list_sonstig = new ListDTO(3, "sonstig");

    private ArrayList<ListDTO> lists = new ArrayList<>(Arrays.asList(getList_schule(), getList_alltag(), getList_sonstig()));

    private ArrayList<UserDTO> users = new ArrayList<>(Arrays.asList(getUser1(), getUser2(), getUserAdmin()));

    private static DatabasePlaceholder instance;
    private DatabasePlaceholder()
    {
        ArrayList<TodoDTO> todo_schule = new ArrayList<>(Arrays.asList(todo1, todo4, todo5));
        ArrayList<TodoDTO> todo_alltag = new ArrayList<>(Arrays.asList(todo2, todo3));
        ArrayList<TodoDTO> todo_sonstig = new ArrayList<>(Arrays.asList(todo6));

        getList_schule().setTodos(todo_schule);
        getList_alltag().setTodos(todo_alltag);
        getList_sonstig().setTodos(todo_sonstig);

        setList_schule(list_schule);
        setList_alltag(list_alltag);
        setList_sonstig(list_sonstig);
    }

    public static DatabasePlaceholder getInstance()
    {
        if(instance == null)
        {
            instance = new DatabasePlaceholder();
        }
        return instance;
    }

    public void addList(ListDTO list) {
        // Would be an SQL query but has to be substitued by Java Code
        lists.add(list);
        getLists().add(list);
    }

    public void deleteList(ListDTO list) {
        // Would be an SQL query but has to be substitued by Java Code
        getLists().remove(list);
    }

    public ListDTO getListById(ListDTO list) {
        // Would be an SQL query but has to be substitued by Java Code
        for (ListDTO listDTO : getLists()) {
            if (listDTO.getId() == list.getId()) {
                return listDTO;
            }
        }
        return null;
    }

    public void addTodoToList(ListDTO list, TodoDTO todo) {
        // Would be an SQL query but has to be substitued by Java Code
        list.getTodos().add(todo);
        System.out.println(list.getName());
    }

    public ListDTO getList_schule() {
        return list_schule;
    }

    public void setList_schule(ListDTO list_schule) {
        this.list_schule = list_schule;
    }

    public ListDTO getList_alltag() {
        return list_alltag;
    }

    public void setList_alltag(ListDTO list_alltag) {
        this.list_alltag = list_alltag;
    }

    public ListDTO getList_sonstig() {
        return list_sonstig;
    }

    public void setList_sonstig(ListDTO list_sonstig) {
        this.list_sonstig = list_sonstig;
    }

    public ArrayList<ListDTO> getLists() {
        return lists;
    }

    public void setLists(ArrayList<ListDTO> lists) {
        this.lists = lists;
    }

    public UserDTO getUser1() {
        return user1;
    }

    public void setUser1(UserDTO user1) {
        this.user1 = user1;
    }

    public UserDTO getUser2() {
        return user2;
    }

    public void setUser2(UserDTO user2) {
        this.user2 = user2;
    }

    public UserDTO getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(UserDTO userAdmin) {
        this.userAdmin = userAdmin;
    }

    public ArrayList<UserDTO> getUsers() {
        return users;
    }
}
