package core.basesyntax.model.dao;

import core.basesyntax.model.model.User;
import java.util.List;

public interface UserDao extends GenericDao<User> {

    @Override
    void add(User user);

    @Override
    List<User> getAll();
}
