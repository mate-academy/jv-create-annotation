package core.basesyntax.factory;

import core.basesyntax.dao.PlayerDao;
import core.basesyntax.dao.PlayerDaoImpl;

public class PlayerDaoFactory {
    private static PlayerDao INSTANCE;

    public static PlayerDao getPlayerDao() {
        if (INSTANCE == null) {
            INSTANCE = new PlayerDaoImpl();
        }
        return INSTANCE;
    }
}