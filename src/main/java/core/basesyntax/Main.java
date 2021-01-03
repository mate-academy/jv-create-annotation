package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.exception.AnnotationNotFoundException;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, AnnotationNotFoundException {
        ConsoleHandler handler = (ConsoleHandler) Injector
                .getInstance(ConsoleHandler.class);
        System.out.println("Enter your username and password");
        handler.handleUser();

        System.out.println("Enter value and risk for your bet");
        handler.handleBet();
    }
}
