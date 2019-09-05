package core.basesyntax.factory;

import core.basesyntax.dao.HumanDao;
import core.basesyntax.dao.HumanDaoImpl;

public class HumanDaoFactory {
    private static HumanDao instance;

    public static HumanDao getHumanDao(){
        if (instance == null){
            instance = new HumanDaoImpl();
        }
        return instance;
    }
}
