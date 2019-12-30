package core.basesyntax.dao;

import core.basesyntax.model.User;

import java.util.Set;

public interface UserDao {
    void add(User user);

    void delete(User user);

    Set<User> getAll();
}
