package core.basesyntax.dao;

import core.basesyntax.Model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    List<User> getAll();
}
