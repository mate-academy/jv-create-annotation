package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.exception.NoSuchAnnotationException;
import core.basesyntax.lib.Dao;

public class Factory {
    private static BetDao betDao;
    private static UserDao userDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            if (BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
                betDao = new BetDaoImpl();
            } else {
                throw new NoSuchAnnotationException("Class haven't Dao annotation!");
            }
        }
        return betDao;
    }

    public static UserDao getUserDao() {
        if (userDao == null) {
            if (UserDaoImpl.class.isAnnotationPresent(Dao.class)) {
                userDao = new UserDaoImpl();
            } else {
                throw new NoSuchAnnotationException("Class haven't Dao annotation!");
            }
        }
        return userDao;
    }
}
