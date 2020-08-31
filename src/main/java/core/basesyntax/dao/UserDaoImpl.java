package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.User;
import java.util.NoSuchElementException;

public class UserDaoImpl implements UserDao {
    @Override
    public void addUser(User user) {
        User.checkPresence(user);
        String login = user.getLogin();
        User.loginCheck(login);
        Storage.STORAGE.put(login, user);
    }

    @Override
    public User getUser(String login) {
        User.loginCheck(login);
        if (Storage.STORAGE.isEmpty()) {
            throw new IllegalArgumentException("Storage is empty");
        }
        if (!User.exists(login)) {
            throw new NoSuchElementException("No such user found");
        }
        return Storage.STORAGE.get(login);
    }
}
