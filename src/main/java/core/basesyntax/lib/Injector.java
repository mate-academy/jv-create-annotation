package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImp;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.dao.HumanDaoImp;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.HumanDaoFactory;

import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Field[] consoleHandlers = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlers) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (BetDaoImp.class.isAnnotationPresent(Dao.class)
                        && field.getType().equals(BetDao.class)) {
                    field.set(null, BetDaoFactory.getBetDao());
                }
                if (HumanDaoImp.class.isAnnotationPresent(Dao.class)
                        && field.getType().equals(HumanDao.class)) {
                    field.set(null, HumanDaoFactory.getHumanDao());
                }
            }
        }
    }
}
