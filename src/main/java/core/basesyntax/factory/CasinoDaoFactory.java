package core.basesyntax.factory;

import core.basesyntax.DAO.CasinoDAO;
import core.basesyntax.DAO.CasinoDaoImpl;

public class CasinoDaoFactory {
    private static CasinoDAO instance;

    public static CasinoDAO getCasinoDao(){
        if(instance == null){
            instance = new CasinoDaoImpl();
        }
        return instance;
    }
}
