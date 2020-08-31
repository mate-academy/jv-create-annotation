package core.basesyntax;

import java.util.Map;

public interface UserDao {
    void add(User user, Bet bet);
    Map<User, Bet> getAll();
}
