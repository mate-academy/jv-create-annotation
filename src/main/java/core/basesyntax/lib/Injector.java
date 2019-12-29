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
        Class<Authentication> authenticationClass = Authentication.class;
        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;
        Class<UserDaoImpl> userDaoClass = UserDaoImpl.class;

        Field[] consoleHandlersFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlersFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && betDaoClass.getDeclaredAnnotation(Dao.class) != null
                    && field.getType() == BetDao.class) {
                field.setAccessible(true);
                field.set(null, BetDaoFactory.getBetDao());
            }
        }

        Field[] authenticationFields = authenticationClass.getDeclaredFields();
        for (Field field : authenticationFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && userDaoClass.getDeclaredAnnotation(Dao.class) != null
                    && field.getType() == UserDao.class) {
                field.setAccessible(true);
                field.set(null, UserDaoFactory.getUserDao());
            }
        }
    }
}
