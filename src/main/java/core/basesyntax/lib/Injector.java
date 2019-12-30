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

    public static void  injectDependency() throws IllegalAccessException {

        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field: consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null && field.getType() == BetDao.class
                    && BetDaoImpl.class.getDeclaredAnnotation(Dao.class) !=  null) {
                field.setAccessible(true);
                field.set(null, BetDaoFactory.getBetDao());
            }
        }
        for (Field field: consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType() == UserDao.class
                    && UserDaoImpl.class.getDeclaredAnnotation(Dao.class) !=  null) {
                field.setAccessible(true);
                field.set(null, UserDaoFactory.getUserDao());
            }
        }
    }
}
