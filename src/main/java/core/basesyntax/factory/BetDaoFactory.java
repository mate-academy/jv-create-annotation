package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;

public class BetDaoFactory {
    private static BetDao instance;

    public static BetDao getDao() {
        if (instance == null) {
            instance = new BetDaoImpl();
        }
        return instance;
    }

}
