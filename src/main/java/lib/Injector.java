package lib;

import controller.ConsoleHandler;
import dao.BetDaoImpl;
import factory.BetDaoFactory;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoImplClass = BetDaoImpl.class;

        Field[] consolHandlersFields = consoleHandlerClass.getDeclaredFields(); //.;
        for (Field field :consolHandlersFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                field.set(null, BetDaoFactory.getBetDao());
            }
        }
    }
}
