package factory;

import dao.BetDao;
import dao.BetDaoImpl;
import lib.Dao;

public class BetDaoFactory {

    private static BetDao betDao;

    public static BetDao getBetDao() throws NoClassDefFoundError {
        if (BetDaoImpl.class.getAnnotation(Dao.class) != null) {
            if (betDao == null) {
                betDao = new BetDaoImpl();
            }
            return betDao;
        }
        throw new NoClassDefFoundError("No Dao Class selected!");
    }
}
