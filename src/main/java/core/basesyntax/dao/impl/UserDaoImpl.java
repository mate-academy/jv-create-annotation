package core.basesyntax.dao.impl;

import core.basesyntax.dao.UserDao;
import core.basesyntax.model.User;
import core.basesyntax.storage.Storage;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        Storage.USERS.add(user);
    }

    @Override
    public List<User> getAll() {
        return Storage.USERS;
    }
}
