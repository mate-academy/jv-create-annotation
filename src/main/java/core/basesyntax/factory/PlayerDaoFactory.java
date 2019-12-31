package core.basesyntax.factory;

import core.basesyntax.dao.PlayerDao;
import core.basesyntax.dao.PlayerDaoImpl;

public class PlayerDaoFactory {
    private static PlayerDao instance;

    public static PlayerDao getPlayerDao() {
        if (instance == null) {
            return instance = new PlayerDaoImpl();
        }
        return instance;
    }
}
