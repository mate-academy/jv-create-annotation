package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.dao.HumanDaoImpl;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.HumanDaoFactory;

import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;

        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)
                        && BetDaoImpl.class.isAnnotationPresent(BetDaoAnn.class)) {
                    field.set(null, BetDaoFactory.getBetDao());
                }
                if (field.getType().equals(HumanDao.class)
                        && HumanDaoImpl.class.isAnnotationPresent(HumanDaoAnn.class)) {
                    field.set(null, HumanDaoFactory.getHumanDao());
                }
            }
        }
    }
}
