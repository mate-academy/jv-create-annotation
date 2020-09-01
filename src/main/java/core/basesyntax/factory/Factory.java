package core.basesyntax.factory;

import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UniversalDao;
import core.basesyntax.dao.UserDaoImpl;

public class Factory {
    private static UniversalDao universalDao;

    public static UniversalDao getBetDao() {
        if (universalDao == null) {
            return new BetDaoImpl();
        }
        return universalDao;
    }

    public static UniversalDao getUserDao() {
        if (universalDao == null) {
            return new UserDaoImpl();
        }
        return universalDao;
    }
}
