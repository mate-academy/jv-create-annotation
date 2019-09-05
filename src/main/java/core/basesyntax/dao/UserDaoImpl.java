package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        Storage.persons.add(user);
    }

    @Override
    public List<User> getAll() {
        return Storage.persons;
    }
}
