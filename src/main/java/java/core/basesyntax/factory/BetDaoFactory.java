package java.core.basesyntax.factory;

import java.core.basesyntax.dao.BetDao;
import java.core.basesyntax.dao.BetDaoImpl;

public class BetDaoFactory {

    private static BetDao instance;

    public static BetDao getBetDao() {
        if (instance == null) {
            instance = new BetDaoImpl();
        }
        return instance;
    }
}
