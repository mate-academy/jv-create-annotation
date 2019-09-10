package core.basesyntax.factory;

import core.basesyntax.dao.GamblerDao;
import core.basesyntax.dao.GamblerDaoImpl;

public class GamblerDaoFactory {
    private static GamblerDao instance;

    public static GamblerDao getUserDao() {
        if (instance == null) {
            instance = new GamblerDaoImpl();
        }
        return instance;
    }
}