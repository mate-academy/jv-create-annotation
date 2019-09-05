package lib;

import controller.ConsoleHandler;
import dao.BetDao;
import dao.UserDao;
import dao.daoImpl.BetDaoImpl;
import dao.daoImpl.UserDaoImpl;
import factory.BetDaoFactory;
import factory.UserDaoFactory;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;

        Field [] consoleHandlersFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlersFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                if(BetDaoImpl.class.getDeclaredAnnotation(Dao.class) != null
                        && field.getType() == BetDao.class) {
                    field.setAccessible(true);
                    field.set(null, BetDaoFactory.getBetDao());
                } else if (UserDaoImpl.class.getDeclaredAnnotation(DaoUser.class) != null
                        && field.getType() == UserDao.class) {
                    field.setAccessible(true);
                    field.set(null, UserDaoFactory.getUserDao());
                }
            }
        }

    }
}
