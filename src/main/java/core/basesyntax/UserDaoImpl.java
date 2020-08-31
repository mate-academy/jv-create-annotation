package core.basesyntax;

import java.util.Map;

public class UserDaoImpl implements UserDao {
    private UserStorage userStorage = new UserStorage();
    @Override
    public void add(User user, Bet bet) {
       userStorage.getUserMap().put(user, bet);
    }

    @Override
    public Map<User, Bet> getAll() {
        return userStorage.getUserMap();
    }
}
