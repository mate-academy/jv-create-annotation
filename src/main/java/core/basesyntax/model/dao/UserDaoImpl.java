package core.basesyntax.model.dao;

import core.basesyntax.model.db.Storage;
import core.basesyntax.model.model.User;
import java.util.List;

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
