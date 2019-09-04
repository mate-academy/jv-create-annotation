package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.factory.BetDaoFactory;

import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();

        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;
        if (betDaoClass.getDeclaredAnnotation(Dao.class) == null) {
            throw new IllegalAccessException();
        }
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) == null) {
                throw new IllegalAccessException();
            }
            field.setAccessible(true);
            field.set(null, BetDaoFactory.getBetDao());
        }

    }
}
