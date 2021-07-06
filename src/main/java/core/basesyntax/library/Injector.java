package core.basesyntax.library;

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
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(UserDao.class)) {
                    if (userDaoClass.getDeclaredAnnotation(DaoImpl.class) != null) {
                        field.set(null, UserDaoFactory.getDao());
                    } else {
                        throw new IllegalArgumentException("Missing proper Annotation");
                    }
                }
                if (field.getType().equals(BetDao.class)) {
                    if (betDaoClass.getDeclaredAnnotation(DaoImpl.class) != null) {
                        field.set(null, BetDaoFactory.getDao());
                    } else {
                        throw new IllegalArgumentException("Missing proper Annotation");
                    }
                }
            }
        }
    }
}
