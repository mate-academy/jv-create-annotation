package core.basesyntax;

import java.util.List;

public interface UserDao {
    void add(User use);

    List<User> getAll();
}
