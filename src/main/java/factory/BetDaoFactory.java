package factory;

import dao.BetDao;
import dao.BetDaoImpl;
import dao.BetDaoJdbcImpl;
import java.lang.annotation.Annotation;
import lib.Dao;

public class BetDaoFactory {

    private static BetDao betDao;

    public static BetDao getBetDao() throws NoClassDefFoundError {
        Class<BetDaoImpl> betDaoImpl = BetDaoImpl.class;
        Class<BetDaoJdbcImpl> betDaoJdbcImpl = BetDaoJdbcImpl.class;
        Annotation annotation1 = betDaoImpl.getAnnotation(Dao.class);
        Annotation annotation2 = betDaoJdbcImpl.getAnnotation(Dao.class);
        if (annotation1 != null) {
            if (betDao == null) {
                betDao = new BetDaoImpl();
            }
            return betDao;
        } else if (annotation2 != null) {
            if (betDao == null) {
                betDao = new BetDaoJdbcImpl();
            }
            return betDao;
        }
        throw new NoClassDefFoundError("No Dao Class selected!");
    }
}
