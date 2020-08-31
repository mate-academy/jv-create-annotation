package core.basesyntax.dao;

import core.basesyntax.model.User;
import java.util.List;

public interface UserDao {
    void add(User user);

    void checkAge(User user);

    List<User> getAllUsers();
}
