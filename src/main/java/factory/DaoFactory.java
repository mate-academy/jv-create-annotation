package factory;

import dao.BetDao;
import dao.BetDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import exceptions.AnnotationIsFailureException;
import lib.Dao;

public class DaoFactory {
    private static BetDao betDao;
    private static UserDao userDao;

    public static BetDao getBetDao() throws AnnotationIsFailureException {
        if (betDao == null) {
            if (BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
                return new BetDaoImpl();
            }
            throw new AnnotationIsFailureException("The required annotation is missing");
        }
        return betDao;
    }

    public static UserDao getUserDao() throws AnnotationIsFailureException {
        if (userDao == null) {
            if (UserDaoImpl.class.isAnnotationPresent(Dao.class)) {
                return new UserDaoImpl();
            }
            throw new AnnotationIsFailureException("Відсутня антотація @Dao у класі UserDao.");
        }
        return userDao;
    }
}
