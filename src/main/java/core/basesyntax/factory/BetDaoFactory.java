package core.basesyntax.factory;

import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.GenericDao;

public class BetDaoFactory {
    private static GenericDao genericDao;

    public static GenericDao getInstance() {
        if (genericDao == null) {
            genericDao = new BetDaoImpl();
        }
        return genericDao;
    }
}
