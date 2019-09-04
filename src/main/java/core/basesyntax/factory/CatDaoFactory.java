package core.basesyntax.factory;

import core.basesyntax.dao.CatDao;
import core.basesyntax.dao.CatDaoImpl;

public class CatDaoFactory {

    private static CatDao instance;

    public static CatDao getCatDao() {
        if (instance == null) {
            instance = new CatDaoImpl();
        }
        return instance;
    }
}
