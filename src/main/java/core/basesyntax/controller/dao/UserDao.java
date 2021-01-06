package core.basesyntax.controller.dao;

import core.basesyntax.controller.model.User;
import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> getAll();
}
