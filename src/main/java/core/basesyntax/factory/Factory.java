package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.CarDao;
import core.basesyntax.dao.CarDaoImpl;
import core.basesyntax.exception.NoAnnotationException;
import core.basesyntax.lib.Dao;

public class Factory {
    private static BetDao betDao;
    private static CarDao carDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            if (BetDaoImpl.class.getAnnotation(Dao.class) == null) {
                throw new NoAnnotationException("BetDaoImpl class has no @Dao annotation");
            }
            betDao = new BetDaoImpl();
        }
        return betDao;
    }

    public static CarDao getCarDao() {
        if (carDao == null) {
            if (CarDaoImpl.class.getAnnotation(Dao.class) == null) {
                throw new NoAnnotationException("CarDaoImpl class has no @Dao annotation");
            }
            carDao = new CarDaoImpl();
        }
        return carDao;
    }
}
