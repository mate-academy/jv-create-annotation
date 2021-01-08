package core.basesyntax.dao;

import core.basesyntax.models.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    Optional<User> get(int id);

    List<User> getAll();

    boolean save(User user);

    boolean delete(Integer id);
}
