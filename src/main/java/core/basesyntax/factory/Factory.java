package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.lib.Dao;

public class Factory {
    private static BetDao betDao;
    private static UserDao userDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            if (BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
                return new BetDaoImpl();
            }
        }
        return betDao;
    }

    public static UserDao getUserDao() {
        if (userDao == null) {
            if (UserDaoImpl.class.isAnnotationPresent(Dao.class)) {
                return new UserDaoImpl();
            }
        }
        return userDao;
    }
}
