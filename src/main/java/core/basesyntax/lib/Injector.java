package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.GamblerDao;
import core.basesyntax.dao.GamblerDaoImpl;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.GamblerDaoFactory;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Field[] consoleHandlerFields = ConsoleHandler.class.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)
                        && BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
                    field.set(null, BetDaoFactory.getBetDao());
                } else if (field.getType().equals(GamblerDao.class)
                        && GamblerDaoImpl.class.isAnnotationPresent(Dao.class)) {
                    field.set(null, GamblerDaoFactory.getGamblerDao());
                }
            }
        }
    }
}
