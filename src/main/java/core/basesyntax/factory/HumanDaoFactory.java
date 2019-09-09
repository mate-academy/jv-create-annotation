package core.basesyntax.factory;

import core.basesyntax.dao.HumanDao;
import core.basesyntax.dao.HumanDaoImpl;

public class HumanDaoFactory {
    private static HumanDao humanDao;

    public static HumanDao getHumanDao() {
        if (humanDao == null) {
            humanDao = new HumanDaoImpl();
        }
        return humanDao;
    }
}
