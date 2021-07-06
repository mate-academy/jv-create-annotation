package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.User;
import java.util.List;

@Dao
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

    @Override
    public List<User> getAll() {
        return Storage.userList;
    }
}
