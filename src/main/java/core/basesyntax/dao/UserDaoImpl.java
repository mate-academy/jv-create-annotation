package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.User;
import java.util.List;

@Dao
public class UserDaoImpl implements UserDao {
    private Storage<User> userStorage;

    public UserDaoImpl() {
        userStorage = new Storage<>();
    }

    @Override
    public void add(User user) {
        userStorage.items.add(user);
    }

    @Override
    public List<User> getAll() {
        return userStorage.items;
    }
}
