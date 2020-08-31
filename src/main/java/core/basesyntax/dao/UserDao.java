package core.basesyntax.dao;

import core.basesyntax.model.User;
import java.util.List;

public interface UserDao {
    void add(User user);

    void delete(User user);

    User getUserById(int id);

    User getUserByName(String name);

    String getUserPassword(String name);

    List<User> getAll();
}
