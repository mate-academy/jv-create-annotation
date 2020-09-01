package core.basesyntax.dao;

import core.basesyntax.lib.Dao;
import core.basesyntax.model.User;
import db.Storage;
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
