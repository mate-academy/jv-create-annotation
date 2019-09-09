package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;

public class BetDaoFactory {
    private static BetDao INSTANCE;

    public static BetDao getBetDao() {
        if (INSTANCE == null) {
            INSTANCE = new BetDaoImpl();
        }
        return INSTANCE;
    }
}