package factory;

import dao.BetDao;
import dao.BetDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;

public class DaoFactory {
    private static BetDao betDao;
    private static UserDao userDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            return new BetDaoImpl();
        }
        return betDao;
    }

    public static UserDao getUserDao() {
        if (userDao == null) {
            return new UserDaoImpl();
        }
        return userDao;
    }
}
