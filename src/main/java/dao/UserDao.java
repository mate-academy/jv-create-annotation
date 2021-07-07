package dao;

import java.util.Set;
import model.User;

public interface UserDao {

    void add(User user);

    Set<User> getAll();
}
