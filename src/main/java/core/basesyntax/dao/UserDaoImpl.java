package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.User;

public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        Storage.userList.add(user);
    }

    @Override
    public User findByLogin(String login) {
        return Storage.userList.stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No such User"));
    }
}
