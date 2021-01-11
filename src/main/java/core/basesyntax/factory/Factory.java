package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;

public class Factory {
    private static BetDao betDao;
    private static FruitDao fruitDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            betDao = new BetDaoImpl();
        }
        return betDao;
    }

    public static FruitDao getFruitDao() {
        if (fruitDao == null) {
            fruitDao = new FruitDaoImpl();
        }
        return fruitDao;
    }
}
