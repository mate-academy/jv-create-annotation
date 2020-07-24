package core.basesyntax.dao;

import core.basesyntax.database.Storage;
import core.basesyntax.library.Dao;
import core.basesyntax.models.User;
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
