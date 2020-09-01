package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.User;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void addUserToStorage(User user) {
        Storage.users.add(user);
    }

    @Override
    public List<User> gerAllUser() {
        return Storage.users;
    }

    @Override
    public void removeUserFromStorage(User user) {
        Storage.users.remove(user);
    }
}
