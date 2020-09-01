package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.impl.BetDaoImpl;
import core.basesyntax.dao.impl.UserDaoImpl;
import core.basesyntax.exceptions.NoAnnotationException;
import core.basesyntax.lib.Dao;

public class Factory {
    public static final String ERROR_MESSAGE = "Please annotate your class";
    private static UserDao userDao;
    private static BetDao betDao;

    public static UserDao getUserDao() {
        if (UserDaoImpl.class.isAnnotationPresent(Dao.class)) {
            return new UserDaoImpl();
        }
        throw new NoAnnotationException(ERROR_MESSAGE + UserDaoImpl.class.getName());
    }

    public static BetDao getBetDao() {
        if (BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
            return new BetDaoImpl();
        }
        throw new NoAnnotationException("Please annotate your class" + BetDaoImpl.class.getName());
    }
}
