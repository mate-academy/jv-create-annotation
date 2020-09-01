package core.basesyntax.factory;

import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UniversalDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.lib.Dao;
import core.basesyntax.lib.NoDaoAnnotationInTheClass;

public class Factory {
    private static UniversalDao universalDao;

    public static UniversalDao getBetDao() throws NoDaoAnnotationInTheClass {
        if (!BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
            throw new NoDaoAnnotationInTheClass(message(BetDaoImpl.class));
        }
        if (universalDao == null) {
            return new BetDaoImpl();
        }
        return universalDao;
    }

    public static UniversalDao getUserDao() throws NoDaoAnnotationInTheClass {
        if (!UserDaoImpl.class.isAnnotationPresent(Dao.class)) {
            throw new NoDaoAnnotationInTheClass(message(UserDaoImpl.class));
        }
        if (universalDao == null) {
            return new UserDaoImpl();
        }
        return universalDao;
    }

    private static String message(Class clazz) {
        return "Class " + clazz
                + " doesn't contains @Dao annotation!!";
    }
}
