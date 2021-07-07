package core.basesyntax.dao;

import core.basesyntax.model.User;

import java.util.List;

public interface UserDao {
    public void add(User user);

    public List<User> getAll();
}
