package dao.daoImpl;

import dao.UserDao;
import db.Storage;
import lib.DaoUser;
import model.User;

import java.util.List;

@DaoUser
public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        Storage.usersList.add(user);
    }

    @Override
    public List<User> getAll() {
        return Storage.usersList;
    }
}
