package core.basesyntax.dao.user;

import core.basesyntax.model.User;
import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> getAllUsers();
}
