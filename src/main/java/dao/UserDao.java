package dao;

import java.util.List;
import model.User;

public interface UserDao {
    void addUser(User user);

    List<User> getAllUsers();
}
