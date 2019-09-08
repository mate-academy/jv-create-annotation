package core.basesyntax.dao;

import core.basesyntax.model.Bet;
import core.basesyntax.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    List<User> getAll();
}
