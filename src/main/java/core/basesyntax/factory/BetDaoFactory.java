package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImplementation;

public class BetDaoFactory {
    private static BetDao instance;

    public static BetDao getBetDao() {
        if (instance == null) {
            instance = new BetDaoImplementation();
        }
        return instance;
    }
}
