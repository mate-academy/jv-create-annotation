package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImp;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImp;
import core.basesyntax.exception.AnnotationNotFoundException;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.UserDaoFactory;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImp> betDaoImpClass = BetDaoImp.class;
        Class<UserDaoImp> userDaoImpClass = UserDaoImp.class;

        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();

        for (Field field : consoleHandlerFields) {
            if (field.getAnnotation(Inject.class) != null && field.getType().equals(BetDao.class)) {
                if (betDaoImpClass.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(null, BetDaoFactory.getBetDao());
                } else {
                    throw new AnnotationNotFoundException();
                }
            }
            if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(UserDao.class)) {
                if (userDaoImpClass.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(null, UserDaoFactory.getUserDao());
                } else {
                    throw new AnnotationNotFoundException();
                }
            }
        }
    }
}
