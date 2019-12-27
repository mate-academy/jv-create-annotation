package core.basesyntax.factory;

import core.basesyntax.DAO.BetDao;
import core.basesyntax.DAO.BetDaoImpl;
import core.basesyntax.lib.Dao;

@Dao
public class BetDAOFactory {
    private static BetDao instance;

    public static BetDao getBetDAO(){
        if(instance == null){
            instance = new BetDaoImpl();
        }
        return instance;
    }
}
