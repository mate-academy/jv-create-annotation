package core.basesyntax.factory;

import core.basesyntax.dao.CasinoDao;
import core.basesyntax.dao.CasinoDaoImpl;
import core.basesyntax.lib.Dao;

public class CasinoDaoFactory {
    private static CasinoDao instance;

    @Dao
    public static CasinoDao getCasinoDao() {
        if (instance == null) {
            instance = new CasinoDaoImpl();
        }
        return instance;
    }
}
