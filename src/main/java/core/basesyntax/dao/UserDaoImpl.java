package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.models.User;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void add(User addUser) {
        for (User user : Storage.USERS) {
            if (addUser.equals(user)) {
                System.out.println("Such user already exists");
                return;
            }
        }
        Storage.USERS.add(addUser);
    }

    @Override
    public List<User> getAll() {
        return Storage.USERS;
    }
}
