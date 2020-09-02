package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConsoleHandler consoleHandler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Input your name, age, value and risk for your bet:");
        consoleHandler.handle();
    }
}
