package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.GamerDao;
import core.basesyntax.dao.GamerDaoImpl;

public class Factory {
    private static BetDao betDao;
    private static GamerDao gamerDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            return new BetDaoImpl();
        }
        return betDao;
    }

    public static GamerDao getGamerDao() {
        if (gamerDao == null) {
            return new GamerDaoImpl();
        }
        return gamerDao;
    }
}
