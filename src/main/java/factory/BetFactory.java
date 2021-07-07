package factory;

import dao.BetDao;
import dao.BetDaoImpl;

public class BetFactory {
    private static BetDao betDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            betDao = new BetDaoImpl();
        }
        return betDao;
    }
}
