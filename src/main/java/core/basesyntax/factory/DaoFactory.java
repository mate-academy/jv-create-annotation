package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;

public class DaoFactory {
    private static BetDao betDaoInstance;
    private static UserDao userDaoInstance;

    public static BetDao getBetDaoInstance() {
        if (betDaoInstance == null) {
            betDaoInstance = new BetDaoImpl();
        }
        return betDaoInstance;
    }

    public static UserDao getUserDaoInstance() {
        if (userDaoInstance == null) {
            userDaoInstance = new UserDaoImpl();
        }
        return userDaoInstance;
    }
}
