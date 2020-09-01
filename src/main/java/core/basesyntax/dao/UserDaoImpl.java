package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.User;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public void addUser(User user) {
        Storage.Users.add(user);
    }

    @Override
    public List<User> getAll() {
        return Storage.Users;
    }
}
