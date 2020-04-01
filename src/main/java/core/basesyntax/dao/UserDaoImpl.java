package core.basesyntax.dao;

import core.basesyntax.db.DataBase;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.User;

import java.util.List;

@Dao
public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        DataBase.users.add(user);

    }

    @Override
    public User get(int number) {
        return DataBase.users.get(number);
    }

    @Override
    public List<User> getAll() {
        return DataBase.users;
    }
}
