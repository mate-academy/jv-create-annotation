package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.User;
import java.util.List;

@Dao
public class UserDaoImpl implements UserDao {
    private Storage<User> userStorage;

    private UserDaoImpl() {
        userStorage = new Storage<>();
    }

    private static class UserDaoHolder {
        private static UserDao userDao = new UserDaoImpl();
    }

    public static UserDao getInstance() {
        return UserDaoHolder.userDao;
    }

    @Override
    public void add(User user) {
        userStorage.add(user);
    }

    @Override
    public List<User> getAll() {
        return userStorage.getItems();
    }
}
