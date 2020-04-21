package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.library.Dao;
import core.basesyntax.model.User;
import java.util.List;

@Dao
public class UserDaoImpl implements UserDao {
    @Override
    public void add(User bet) {
        Storage.USERS.add(bet);
    }

    @Override
    public List<User> getAll() {
        return Storage.USERS;
    }
}
