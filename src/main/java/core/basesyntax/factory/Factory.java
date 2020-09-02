package core.basesyntax.factory;

import core.basesyntax.dao.bet.BetDao;
import core.basesyntax.dao.bet.BetDaoImpl;
import core.basesyntax.dao.user.UserDao;
import core.basesyntax.dao.user.UserDaoImpl;

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
