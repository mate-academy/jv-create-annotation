package core.basesyntax.model.factory;

import core.basesyntax.model.dao.BetDao;
import core.basesyntax.model.dao.BetDaoImpl;
import core.basesyntax.model.dao.UserDao;
import core.basesyntax.model.dao.UserDaoImpl;

public class Factory {
    private static BetDao betDao;
    private static UserDao userDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            betDao = new BetDaoImpl();
        }

        return betDao;
    }

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }

        return userDao;
    }
}
