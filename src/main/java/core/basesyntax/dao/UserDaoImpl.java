package core.basesyntax.dao;

import core.basesyntax.library.Dao;
import core.basesyntax.model.User;
import core.basesyntax.storage.ListStorage;
import java.util.List;

@Dao
public class UserDaoImpl implements UserDao {
    @Override
    public void addNewUser(User user) {
        ListStorage.userStorage.add(user);
        System.out.println(user + "\n User added.");
    }

    @Override
    public List<User> getAll() {
        return ListStorage.userStorage;
    }
}
