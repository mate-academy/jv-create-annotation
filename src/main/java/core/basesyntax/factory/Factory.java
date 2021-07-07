package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.PearsonDao;
import core.basesyntax.dao.PearsonDaoImpl;

public class Factory {
    private static BetDao betDao;
    private static PearsonDao pearsonDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            betDao = new BetDaoImpl();
        }
        return betDao;
    }

    public static PearsonDao getPearsonDao() {
        if (pearsonDao == null) {
            pearsonDao = new PearsonDaoImpl();
        }
        return pearsonDao;
    }
}
