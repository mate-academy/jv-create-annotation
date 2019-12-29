package factory;

import dao.betDao;
import dao.betDaoImpl;

public class betDaoFactory {

    private static betDao instance;

    public static betDao getBetDao() {
        if (instance == null) {
            instance = new betDaoImpl();
        }
        return instance;
    }
}
