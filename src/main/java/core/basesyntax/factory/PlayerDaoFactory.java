package core.basesyntax.factory;

import core.basesyntax.dao.PlayerDao;
import core.basesyntax.dao.PlayerDaoImplementation;

public class PlayerDaoFactory {
    private static PlayerDao instance;

    public static PlayerDao getPlayerDao() {
        if (instance == null) {
            instance = new PlayerDaoImplementation();
        }
        return instance;
    }
}
