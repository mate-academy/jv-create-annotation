package core.basesyntax.factory;

import core.basesyntax.dao.PlayerDao;
import core.basesyntax.dao.PlayerDaoImpl;

public class PlayerDaoFactory {
    private static PlayerDao instance;

    private PlayerDaoFactory() {
    }

    public static PlayerDao getPlayerDao() {
        if (instance == null) {
            instance = new PlayerDaoImpl();
        }
        return instance;
    }
}
