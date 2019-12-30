package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.User;

import java.util.Set;

@Dao
public class UserDaoImp implements UserDao {
    @Override
    public void add(User user) {
        Storage.user.add(user);
    }

    @Override
    public void delete(User user) {
        Storage.user.remove(user);
    }

    @Override
    public Set<User> getAll() {
        return Storage.user;
    }
}
