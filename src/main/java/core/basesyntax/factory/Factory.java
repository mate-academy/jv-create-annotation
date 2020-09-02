package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.CarDao;
import core.basesyntax.dao.CarDaoImpl;

public class Factory {
    private static BetDao betDao;
    private static CarDao carDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            betDao = new BetDaoImpl();
        }
        return betDao;
    }

    public static CarDao getCarDao() {
        if (carDao == null) {
            carDao = new CarDaoImpl();
        }
        return carDao;
    }
}
