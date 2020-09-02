package core.basesyntax.model.dao;

import core.basesyntax.model.model.User;
import java.util.List;

public interface UserDao {

    void add(User user);

    List<User> getAll();
}
