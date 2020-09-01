package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.exception.AnnotationAbsentException;
import core.basesyntax.lib.Dao;

public class Factory {
    public static final String EXCEPTION_MESSAGE = " class doesnt have Dao annotation";
    private static BetDao betDao;
    private static UserDao userDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            if (BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
                betDao = new BetDaoImpl();
            } else {
                throw new AnnotationAbsentException("BetDaoImpl" + EXCEPTION_MESSAGE);
            }
        }
        return betDao;
    }

    public static UserDao getUserDao() {
        if (userDao == null) {
            if (UserDaoImpl.class.isAnnotationPresent(Dao.class)) {
                userDao = new UserDaoImpl();
            } else {
                throw new AnnotationAbsentException("UserDaoImpl" + EXCEPTION_MESSAGE);
            }
        }
        return userDao;
    }
}
