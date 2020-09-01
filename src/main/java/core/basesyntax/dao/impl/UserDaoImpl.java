package core.basesyntax.dao.impl;

import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.User;
import core.basesyntax.storage.Storage;
import java.util.List;

@Dao
public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        Storage.users.add(user);
    }

    @Override
    public List<User> getAll() {
        return Storage.users;
    }
}
