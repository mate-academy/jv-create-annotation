package core.basesyntax.factory;

import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UniversalDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.lib.Dao;
import core.basesyntax.lib.NoDaoAnnotationInTheClass;

public class Factory {
    private static UniversalDao universalDao;

    public static UniversalDao getBetDao() throws NoDaoAnnotationInTheClass {
        if (universalDao == null) {
            if (BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
                return new BetDaoImpl();
            } else {
                throw new NoDaoAnnotationInTheClass(message(BetDaoImpl.class));
            }
        }
        return universalDao;
    }

    public static UniversalDao getUserDao() throws NoDaoAnnotationInTheClass {
        if (universalDao == null) {
            if (UserDaoImpl.class.isAnnotationPresent(Dao.class)) {
                return new UserDaoImpl();
            } else {
                throw new NoDaoAnnotationInTheClass(message(UserDaoImpl.class));
            }
        }
        return universalDao;
    }

    private static String message(Class clazz) {
        return "Class " + clazz
                + " doesn't contains @Dao annotation!!";
    }
}
