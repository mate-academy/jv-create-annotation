package core.basesyntax.factory;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;

public class FactoryFruit {
    private static FruitDao fruitDao;

    public static FruitDao getFruitDao() {
        if (fruitDao == null) {
            fruitDao = new FruitDaoImpl();
        }
        return fruitDao;
    }
}
