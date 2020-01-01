package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.CustomDaoClass;

public class AnotherBetDaoFactory {
    private static CustomDaoClass betDaoImpl;

    public static BetDao getBetDao() {
        if (betDaoImpl == null) {
            betDaoImpl = new CustomDaoClass();
        }
        return betDaoImpl;
    }
}
