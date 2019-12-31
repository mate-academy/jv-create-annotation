package core.basesyntax.src.factory;

import core.basesyntax.src.dao.PlayerDao;
import core.basesyntax.src.dao.PlayerDaoImpl;

public class PlayerDaoFactory {

    private static PlayerDao instance;

    public static PlayerDao getDao() {
        if (instance == null) {
            instance = new PlayerDaoImpl();
        }
        return instance;
    }
}
