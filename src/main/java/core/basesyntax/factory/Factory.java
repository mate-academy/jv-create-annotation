package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImplementation;
import core.basesyntax.dao.BetUserDao;
import core.basesyntax.dao.BetUserDaoImplementation;

public class Factory {
    private static BetDao betDao;
    private static BetUserDao betUserDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            betDao = new BetDaoImplementation();
        }
        return betDao;
    }

    public static BetUserDao getBetUserDao() {
        if (betUserDao == null) {
            betUserDao = new BetUserDaoImplementation();
        }
        return betUserDao;
    }
}
