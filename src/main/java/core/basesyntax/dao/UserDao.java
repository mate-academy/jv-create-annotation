package core.basesyntax.dao;

import core.basesyntax.models.User;
import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> getAllUsers();
}
