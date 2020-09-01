package core.basesyntax.model.dao;

import core.basesyntax.model.lib.Dao;
import core.basesyntax.model.model.User;
import java.util.List;

@Dao
public interface UserDao {

    void add(User user);

    List<User> getAll();
}
