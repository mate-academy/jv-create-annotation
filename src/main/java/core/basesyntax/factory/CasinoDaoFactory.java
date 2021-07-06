package core.basesyntax.factory;

import core.basesyntax.dao.CasinoDao;
import core.basesyntax.dao.CasinoDaoImpl;

public class CasinoDaoFactory {
    private static CasinoDao instance;

    public static CasinoDao getCasinoDao() {
        if (instance == null) {
            instance = new CasinoDaoImpl();
        }
        return instance;
    }
}
