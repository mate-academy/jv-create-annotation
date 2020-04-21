package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.CatDao;
import core.basesyntax.dao.CatDaoImpl;

public class Factory {
    private static BetDao betDao;
    private static CatDao catDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            betDao = new BetDaoImpl();
        }
        return betDao;
    }

    public static CatDao getCatDao() {
        if (catDao == null) {
            catDao = new CatDaoImpl();
        }
        return catDao;
    }
}
