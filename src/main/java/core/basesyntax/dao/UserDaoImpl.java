package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.models.UserModel;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void addUser(UserModel user) {
        Storage.users.add(user);
    }

    @Override
    public List<UserModel> users() {
        return Storage.users;
    }
}
