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
    public static void injectDependency() throws Exception {
        Class<ConsoleHandler> consoleHandler = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;
        Class<UserDaoImpl> userDaoClass = UserDaoImpl.class;
        Field[] fields = consoleHandler.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(BetDao.class)) {
                if (betDaoClass.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(null, BetDaoFactory.getBetDao());
                } else {
                    throw new IllegalArgumentException("Can't find annotation");
                }
            }
            if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(UserDao.class)) {
                if (userDaoClass.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(null, UserDaoFactory.getUserDao());
                } else {
                    throw new IllegalArgumentException("Can't find annotation");
                }
            }
        }
    }
}
