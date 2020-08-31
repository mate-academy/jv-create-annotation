package core.basesyntax.dao.impl;

import core.basesyntax.dao.UserDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public boolean addUser(User user) {
        return Storage.userStorage.add(user);
    }

    @Override
    public User getUserById(long id) {
        return Storage.userStorage
                .stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<User> getAllUsers() {
        return Storage.userStorage;
    }

    @Override
    public void changeUserPassword(long id, String newPassword) {
        getUserById(id).setPassword(newPassword);
    }

    @Override
    public List<Bet> getAllUserBets(long id) {
        return getUserById(id).getUserBets();
    }
}
