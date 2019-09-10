package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;

public class BetDaoFactory {
    public static BetDao instance;

    public static BetDao getLibrary() {
        if (instance == null) {
            instance = new BetDaoImpl();
        }
        return instance;
    }
}
