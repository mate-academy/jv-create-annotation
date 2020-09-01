package core.basesyntax.factory;

import core.basesyntax.dao.bet.BetDao;
import core.basesyntax.dao.bet.BetDaoImpl;
import core.basesyntax.dao.user.UserDao;
import core.basesyntax.dao.user.UserDaoImpl;
import core.basesyntax.exception.AnnotationDaoIsAbsentException;
import core.basesyntax.lib.Dao;

public class Factory {
    public static final String DAO_ANNOTATION_EXCEPTION_MESSAGE
            = "There is no 'Dao' annotation in class ";
    private static BetDao betDao;
    private static UserDao userDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            if (BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
                betDao = new BetDaoImpl();
            } else {
                throw new AnnotationDaoIsAbsentException(DAO_ANNOTATION_EXCEPTION_MESSAGE
                        + BetDaoImpl.class.getSimpleName());
            }
        }
        return betDao;
    }

    public static UserDao getUserDao() {
        if (userDao == null) {
            if (UserDaoImpl.class.isAnnotationPresent(Dao.class)) {
                userDao = new UserDaoImpl();
            } else {
                throw new AnnotationDaoIsAbsentException(DAO_ANNOTATION_EXCEPTION_MESSAGE
                        + UserDaoImpl.class.getSimpleName());
            }
        }
        return userDao;
    }
}
