package factory;

import dao.BetDao;
import dao.BetDaoImpl;
import dao.HorseDao;
import dao.HorseDaoImpl;

public class Factory {
    private static BetDao betDao;
    private static HorseDao horseDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            betDao = new BetDaoImpl();
        }
        return betDao;
    }

    public static HorseDao getHorseDao() {
        if (horseDao == null) {
            horseDao = new HorseDaoImpl();
        }
        return horseDao;
    }
}
