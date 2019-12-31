package core.basesyntax.factories;

import core.basesyntax.dao.GamerDao;
import core.basesyntax.dao.GamerDaoImpl;

public class GamerDaoFactory {
    private static GamerDao instance;

    public static GamerDao getGamerDao() {
        if (instance == null) {
            return new GamerDaoImpl();
        }
        return instance;
    }
}
