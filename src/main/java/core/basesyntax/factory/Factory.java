package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.imp.BetDaoImpl;
import core.basesyntax.dao.imp.UserDaoImpl;
import core.basesyntax.exceptions.MissingAnnotationException;
import core.basesyntax.lib.Dao;

public class Factory {
    private static BetDao betDao;
    private static UserDao userDao;

    public static BetDao getBetDaoImpl() {
        if (betDao == null) {
            if (BetDaoImpl.class.getAnnotation(Dao.class) == null) {
                throw new MissingAnnotationException("Missing annotation");
            }
            return new BetDaoImpl();
        }
        return betDao;
    }

    public static UserDao getUserDaoImpl() {
        if (userDao == null) {
            if (UserDaoImpl.class.getAnnotation(Dao.class) == null) {
                throw new MissingAnnotationException("Missing annotation");
            }
            return new UserDaoImpl();
        }
        return userDao;
    }
}
