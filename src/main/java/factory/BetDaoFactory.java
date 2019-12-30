package factory;

import dao.BetDao;
import dao.BetDaoImpl;

public class BetDaoFactory {

    private static BetDao instance;

    public static BetDao getBetDao() {
        return instance == null ? instance = new BetDaoImpl() : instance;
    }
}
