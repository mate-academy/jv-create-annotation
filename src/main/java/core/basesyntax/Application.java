package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Application {
    public static void main(String[] args) {
        try {
            ConsoleHandler consoleHandler = (ConsoleHandler)
                    Injector.getInstance(ConsoleHandler.class);
            consoleHandler.handle();
        } catch (NoSuchMethodException
                | IllegalAccessException
                | InvocationTargetException
                | InstantiationException e) {
            System.out.println("Failed to inject DaoImpl");
        }

    }
}
