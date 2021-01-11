package core.basesyntax.dao;

import core.basesyntax.model.User;
import java.util.List;

public interface UserDao {
    void add(User user);

    User getUser(User user);

    List<User> getAllUsers();
}
