package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;

public class Factory {
    private static BetDao betDao;
    private static UserDao userDao;

    public static Object getDao(Class getClass) {
        if (getClass == BetDao.class) {
            return getBetDao();
        }
        if (getClass == UserDao.class) {
            return getUserDao();
        }
        throw new RuntimeException(getClass.getSimpleName() + " does not exist");
    }

    public static BetDao getBetDao() {
        if (betDao == null) {
            betDao = new BetDaoImpl();
        }
        return betDao;
    }

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }
}
