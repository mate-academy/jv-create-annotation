package core.basesyntax.dao;

import core.basesyntax.model.User;
import db.Storage;
import java.util.List;

public class UserDaoImpl implements Dao<User> {
    @Override
    public void add(User user) {
        Storage.users.add(user);
    }

    @Override
    public List<User> getAll() {
        return Storage.users;
    }
}
