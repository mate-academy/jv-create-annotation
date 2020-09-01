package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.imp.BetDaoImpl;
import core.basesyntax.dao.imp.UserDaoImpl;

public class Factory {
    private static BetDao betDao;
    private static UserDao userDao;

    public static BetDao getBetDaoImpl() {
        if (betDao == null) {
            return new BetDaoImpl();
        }
        return betDao;
    }

    public static UserDao getUserDaoImpl() {
        if (userDao == null) {
            return new UserDaoImpl();
        }
        return userDao;
    }
}
