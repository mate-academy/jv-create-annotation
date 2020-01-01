package dao;

import db.Storage;

import java.util.List;

import lib.Dao;
import models.User;

@Dao
public class UserDaoImpl implements UserDao {

    @Override
    public void add(User user) {

        Storage.users.add(user);
    }

    @Override
    public List<User> getAll() {

        return Storage.users;
    }
}
