package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.impl.BetDaoImpl;
import core.basesyntax.dao.impl.UserDaoImpl;

public class Factory {
    private static UserDao userDao;
    private static BetDao betDao;

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    public static BetDao getBetDao() {
        if (betDao == null) {
            betDao = new BetDaoImpl();
        }
        return betDao;
    }
}
