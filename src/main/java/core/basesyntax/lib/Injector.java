package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.UserDaoFactory;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoImplClass = BetDaoImpl.class;
        Class<UserDaoImpl> userDaoImplClass = UserDaoImpl.class;

        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType().equals(BetDao.class)) {
                if (betDaoImplClass.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(null, BetDaoFactory.getBetDao());
                }
            }
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType().equals(UserDao.class)) {
                if (userDaoImplClass.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(null, UserDaoFactory.getUserDao());
                }
            }
        }
    }
}
