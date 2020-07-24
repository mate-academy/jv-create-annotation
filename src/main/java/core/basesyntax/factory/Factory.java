package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImp;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;

public class Factory {
    public static BetDao betDao;
    public static UserDao userDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            betDao = new BetDaoImp();
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
