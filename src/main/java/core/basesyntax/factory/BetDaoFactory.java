package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.exception.NoSuchInjectionObjectException;
import core.basesyntax.lib.Dao;

public class BetDaoFactory {
    private static BetDao betDao;

    public static BetDao getInstance() {
        if (BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
            if (betDao == null) {
                betDao = new BetDaoImpl();
            }
            return betDao;
        }
        throw new NoSuchInjectionObjectException("The required injection object was not found");
    }
}
