package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;

public class Factory {
    private static BetDao instanceBet;
    private static UserDao instanceUser;

    public static BetDao getBetDao() {
        if (instanceBet == null) {
            instanceBet = new BetDaoImpl();
        }
        return instanceBet;
    }

    public static UserDao getUserDao() {
        if (instanceUser == null) {
            instanceUser = new UserDaoImpl();
        }
        return instanceUser;
    }
}
