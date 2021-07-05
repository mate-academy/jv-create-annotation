package core.basesyntax.factrory;

import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.dao.interfaces.BetDao;
import core.basesyntax.dao.interfaces.UserDao;

public class Factory {
    private static BetDao betDao;
    private static UserDao userDao;

    public static BetDao getBetDao() {
        return betDao == null ? new BetDaoImpl() : betDao;
    }

    public static UserDao getUserDao() {
        return userDao == null ? new UserDaoImpl() : userDao;
    }
}
