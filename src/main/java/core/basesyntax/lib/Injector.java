package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.dao.UserEmailDao;
import core.basesyntax.dao.UserEmailDaoImpl;
import core.basesyntax.factory.UserDaoFactory;
import core.basesyntax.factory.UserEmailDaoFactory;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<UserEmailDaoImpl> userEmailDaoClass = UserEmailDaoImpl.class;
        Class<UserDaoImpl> userDaoClass = UserDaoImpl.class;

        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                if (field.getType() == UserEmailDao.class
                        && UserEmailDaoImpl.class.getDeclaredAnnotation(Dao.class) != null) {
                    field.setAccessible(true);
                    field.set(null, UserEmailDaoFactory.getUserEmailDao());
                }
                if (field.getType() == UserDao.class
                        && UserDaoImpl.class.getDeclaredAnnotation(Dao.class) != null) {
                    field.setAccessible(true);
                    field.set(null, UserDaoFactory.getUserDao());
                }
            }
        }
    }
}
