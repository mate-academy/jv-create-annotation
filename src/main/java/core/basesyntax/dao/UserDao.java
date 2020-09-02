package core.basesyntax.dao;

import core.basesyntax.model.User;
import java.util.List;

public interface UserDao {
    void addUserToStorage(User user);

    List<User> gerAllUsers();

    void removeUserFromStorage(User user);
}
