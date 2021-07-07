package core.basesyntax.dao;

import core.basesyntax.model.User;
import core.basesyntax.storage.Storage;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private Storage storage = new Storage();

    @Override
    public void add(User user) {
        storage.getUserList().add(user);
    }

    @Override
    public List<User> getAll() {
        return storage.getUserList();
    }
}
