package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.HumanDaoImpl;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.HumanDaoFactory;

import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException {
        Field[] consoleHandlerFields = ConsoleHandler.class.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                if (BetDaoImpl.class.getDeclaredAnnotation(Dao.class) != null) {
                    field.setAccessible(true);
                    field.set(null, BetDaoFactory.getBetDao());
                    break;
                }
            }
        }
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(InjectHuman.class) != null) {
                if (HumanDaoImpl.class.getDeclaredAnnotation(Base.class) != null) {
                    field.setAccessible(true);
                    field.set(null, HumanDaoFactory.getHumanDao());
                    break;
                }
            }
        }
    }
}
