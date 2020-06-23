package datalayer.dao;

import datalayer.dto.DatabasePlaceholder;
import datalayer.dto.UserDTO;

import java.util.ArrayList;

public class LoginDAO {

    public ArrayList<UserDTO> getAllUsers() {
        DatabasePlaceholder databasePlaceholder = DatabasePlaceholder.getInstance();
        ArrayList<UserDTO> users = databasePlaceholder.getUsers();
        return users;
    }

}
