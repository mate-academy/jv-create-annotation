package core.basesyntax;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private UserStorage userStorage = new UserStorage();

    @Override
    public void add(User user) {
        userStorage.getUserList().add(user);
    }

    @Override
    public List<User> getAll() {
        return userStorage.getUserList();
    }
}
