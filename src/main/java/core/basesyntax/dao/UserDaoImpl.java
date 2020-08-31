package core.basesyntax.dao;

import core.basesyntax.model.User;
import core.basesyntax.storage.ListStorageUser;

public class UserDaoImpl implements UserDao {
    @Override
    public void addNewUser(User user) {
        ListStorageUser listStorageUser = new ListStorageUser();
        listStorageUser.addUser(user);
    }
}
