package services;

import dao.UserDao;
import dao.UserDaoImpl;
import db.Storage;
import java.util.List;
import model.Bet;
import model.User;

public class UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return new UserDaoImpl();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<Bet> printUsersBetList(User user) {
        List<Bet> result = user.getBetsList();
        System.out.println(result);
        return result;
    }
}
