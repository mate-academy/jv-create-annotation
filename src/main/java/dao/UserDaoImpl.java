package dao;

import database.Storage;

import java.util.List;

import lib.Dao;
import model.User;

@Dao
public class UserDaoImpl implements UserDao {

    @Override
    public void add(User user) {
        Storage.userData.add(user);
    }

    @Override
    public List<User> getAll() {
        return Storage.userData;
    }
}
