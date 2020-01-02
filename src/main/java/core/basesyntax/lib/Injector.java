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

    public static void injectDependecy() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<UserDaoImpl> userDaoClass = UserDaoImpl.class;
        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;

        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.isAnnotationPresent(Inject.class)
                    && field.getType().equals(UserDao.class)
                    && userDaoClass.isAnnotationPresent(Dao.class)) {
                field.setAccessible(true);
                field.set(null, UserDaoFactory.getUserDao());
            }
            if (field.isAnnotationPresent(Inject.class)
                    && field.getType().equals(BetDao.class)
                    && betDaoClass.isAnnotationPresent(Dao.class)) {
                field.setAccessible(true);
                field.set(null, BetDaoFactory.getBetDao());
            }
        }
    }
}
