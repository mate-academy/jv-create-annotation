package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.PlayerDao;
import core.basesyntax.dao.PlayerDaoImpl;

public class Factory {
    private static BetDao betDao;
    private static PlayerDao playerDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            betDao = new BetDaoImpl();
        }
        return betDao;
    }

    public static PlayerDao getPlayerDao() {
        if (playerDao == null) {
            playerDao = new PlayerDaoImpl();
        }
        return playerDao;
    }
}
