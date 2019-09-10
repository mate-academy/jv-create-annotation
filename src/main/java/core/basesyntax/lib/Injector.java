package core.basesyntax.lib;

import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDaoImpl;

import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> libraryImpClass = BetDaoImpl.class;
        Field[] consoleHadlersFields = consoleHandlerClass.getDeclaredFields();
        for(Field field : consoleHadlersFields) {
            if(field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                field.set(null, BetDaoFactory.getLibrary());
            }
        }
    }
}
