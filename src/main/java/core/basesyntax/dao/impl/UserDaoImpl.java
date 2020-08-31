package core.basesyntax.dao.impl;

import core.basesyntax.dao.UserDao;
import core.basesyntax.db.UserStorage;
import core.basesyntax.model.User;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public boolean addUser(User user) {
        return UserStorage.userStorage.add(user);
    }

    @Override
    public User getUserById(long id) {
        return UserStorage.userStorage
                .stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<User> getAllUsers() {
        return UserStorage.userStorage;
    }

    @Override
    public void changeUserPassword(long id, String newPassword) {
        getUserById(id).setPassword(newPassword);
    }
}
