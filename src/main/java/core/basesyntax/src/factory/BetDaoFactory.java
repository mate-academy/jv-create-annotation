package core.basesyntax.src.factory;

import core.basesyntax.src.dao.BetDao;
import core.basesyntax.src.dao.BetDaoImpl;

public class BetDaoFactory {

    private static BetDao instance;

    public static BetDao getDao() {
        if (instance == null) {
            instance = new BetDaoImpl();
        }
        return instance;
    }
}
