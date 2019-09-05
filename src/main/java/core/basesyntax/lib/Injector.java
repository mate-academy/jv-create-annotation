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
        Field[] consoleHandlerFields = ConsoleHandler.class.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType() == BetDao.class) {
                if (BetDaoImpl.class.getDeclaredAnnotation(Dao.class) != null) {
                    field.setAccessible(true);
                    field.set(null, BetDaoFactory.getBetDao());
                    break;
                }
            }
        }
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(InjectHuman.class) != null
                    && field.getType() == HumanDao.class) {
                if (HumanDaoImpl.class.getDeclaredAnnotation(Base.class) != null) {
                    field.setAccessible(true);
                    field.set(null, HumanDaoFactory.getHumanDao());
                    break;
                }
            }
        }
    }
}
