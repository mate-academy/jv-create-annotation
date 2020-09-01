package core.basesyntax.dao;

import core.basesyntax.model.User;

public interface UserDao {
    void add(User user);

    User getByLogin(String login);
}
