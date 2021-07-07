package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.exceptions.NoSuchDaoImplementationException;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException,
            NoSuchDaoImplementationException {

        System.out.println("Please enter value and risk for your bet, "
                + "followed with your name and age! Enter 'Q' to exit.");
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        handler.handle();
    }
}
