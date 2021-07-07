package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.library.Dao;
import core.basesyntax.models.User;
import java.util.List;

@Dao
public class UserDaoImpl implements UserDao {
    @Override
    public void add(User addUser) {
        Storage.users.add(addUser);
    }

    @Override
    public List<User> getAll() {
        return Storage.users;
    }
}
