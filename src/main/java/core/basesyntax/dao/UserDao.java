package core.basesyntax.dao;

import core.basesyntax.model.User;

public interface UserDao {
    void addUser(User user);

    User getUser(String login);
}
