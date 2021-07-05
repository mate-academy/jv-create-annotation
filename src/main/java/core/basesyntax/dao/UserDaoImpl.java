package core.basesyntax.dao;

import core.basesyntax.data.UserStorage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.User;
import java.util.List;

@Dao
public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        UserStorage.users.add(user);
    }

    @Override
    public List<User> getAll() {
        return UserStorage.users;
    }
}
