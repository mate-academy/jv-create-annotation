package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;

public class BetDaoFactory {
    private static BetDaoImpl betDaoImpl;
    public static BetDao getBetDao() {
        if (betDaoImpl == null) {
            betDaoImpl = new BetDaoImpl();
        }
        return betDaoImpl;
    }
}
