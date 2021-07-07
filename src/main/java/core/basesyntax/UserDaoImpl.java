package core.basesyntax;

import java.util.List;

@Dao
public class UserDaoImpl implements UserDao {

    @Override
    public void add(User user) {
        Storage.getUserList().add(user);
    }

    @Override
    public List<User> getAll() {
        return Storage.getUserList();
    }
}
