package core.basesyntax.dao;

import core.basesyntax.model.User;
import core.basesyntax.storage.ListStorage;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void addNewUser(User user) {
        ListStorage.userStorage.add(user);
        System.out.println(user + " User added.");
    }

    @Override
    public List<User> getAll() {
        return ListStorage.userStorage;
    }
}
