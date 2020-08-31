package core.basesyntax.dao;

import core.basesyntax.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    User findByLogin(String login);

    List<User> getAll();
}
