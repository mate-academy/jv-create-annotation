package lib;

import controllers.ConsoleHandler;
import factories.BetDaoFactory;
import factories.CustomerDaoFactory;

import java.lang.reflect.Field;

public class Injector {

    public static void  injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;

        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if ("betDao".equals(field.getName())) {
                    field.set(null, BetDaoFactory.getBetDao());
                } else {
                    field.set(null, CustomerDaoFactory.getCustomerDao());
                }
            }
        }
    }
}
