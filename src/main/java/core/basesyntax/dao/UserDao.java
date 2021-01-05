package core.basesyntax.dao;

import core.basesyntax.model.User;
import java.util.List;

public interface UserDao {
    void saveAsGambler(User user);

    List<User> getAllGamblers();
}
