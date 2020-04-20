package core.basesyntax.factory;

import core.basesyntax.dao.HumanDao;
import core.basesyntax.dao.HumanHumanDaoImpl;

public class HumanDaoFactory {
    private static HumanDao instance;

    public static HumanDao getHumanDao() {
        if (instance == null) {
            instance = new HumanHumanDaoImpl();
        }
        return instance;
    }
}
