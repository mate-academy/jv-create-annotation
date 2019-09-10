package core.basesyntax.lib;

import core.basesyntax.controllers.ConsoleHandler;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.factory.DaoFactory;

import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;
        Class<UserDaoImpl> userDaoClass = UserDaoImpl.class;

        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                if (field.getName().equals("betDao")) {
                    if (betDaoClass.getDeclaredAnnotation(Dao.class) == null) {
                        throw new IllegalAccessException();
                    }
                    field.setAccessible(true);
                    field.set(null, DaoFactory.getBetDaoInstance());
                } else if (field.getName().equals("userDao")) {
                    if (userDaoClass.getDeclaredAnnotation(Dao.class) == null) {
                        throw new IllegalAccessException();
                    }
                    field.setAccessible(true);
                    field.set(null, DaoFactory.getUserDaoInstance());
                }
            }
        }
    }
}
