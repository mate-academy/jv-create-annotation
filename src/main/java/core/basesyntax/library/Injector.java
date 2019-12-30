package core.basesyntax.library;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.UserDaoFactory;

import java.lang.reflect.Field;

public class Injector {
    public static void injectDependecy() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(UserDao.class)) {
                    field.set(null, UserDaoFactory.getDao());
                } else if (field.getType().equals(BetDao.class)) {
                    field.set(null, BetDaoFactory.getDao());
                }
            }
        }
    }
}
