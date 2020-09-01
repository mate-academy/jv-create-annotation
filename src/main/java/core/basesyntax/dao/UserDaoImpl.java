package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.User;
import java.util.List;

@Dao
public class UserDaoImpl implements GenericDao<User> {

    @Override
    public void addModelToDb(User user) {
        Storage.USERS_STORAGE.add(user);
    }

    @Override
    public List<User> getAll() {
        return Storage.USERS_STORAGE;
    }
}
