package core.basesyntax.lib;

import core.basesyntax.controllers.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.factory.DaoFactory;

import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;
        Class<UserDaoImpl> userDaoClass = UserDaoImpl.class;

        if (betDaoClass.getDeclaredAnnotation(Dao.class) == null
                || userDaoClass.getDeclaredAnnotation(Dao.class) == null) {
            throw new IllegalAccessException();
        }

        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field f : consoleHandlerFields) {
            if (f.getDeclaredAnnotation(Inject.class) != null) {
                if (f.getName().equals("betDao")) {
                    f.setAccessible(true);
                    f.set(null, DaoFactory.getBetDaoInstance());
                } else if (f.getName().equals("userDao")) {
                    f.setAccessible(true);
                    f.set(null, DaoFactory.getUserDaoInstance());
                }
            }
        }
    }
}
