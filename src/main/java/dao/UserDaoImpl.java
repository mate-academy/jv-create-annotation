package dao;

import database.Storage;
import java.util.Set;
import lib.Dao;
import model.User;

@Dao
public class UserDaoImpl implements UserDao {

    @Override
    public void add(User user) {
        Storage.users.add(user);
    }

    @Override
    public Set<User> getAll() {
        return Storage.users;
    }
}
