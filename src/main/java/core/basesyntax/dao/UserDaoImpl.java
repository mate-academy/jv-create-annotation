package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.User;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private Storage<User> userStorage = new Storage<>();

    @Override
    public void add(User user) {
        userStorage.add(user);
    }

    @Override
    public List<User> getAll() {
        return userStorage.getItems();
    }
}
