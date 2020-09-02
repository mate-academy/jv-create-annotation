package dao;

import db.Storage;
import java.util.List;
import lib.Dao;
import model.User;

@Dao
public class UserDaoImpl implements UserDao {

    @Override
    public void addUser(User user) {
        Storage.users.add(user);
    }

    @Override
    public List<User> getAllUsers() {
        return Storage.users;
    }
}
