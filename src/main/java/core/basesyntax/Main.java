package core.basesyntax;

import core.basesyntax.exception.NoAnnotationsExceptions;
import core.basesyntax.handler.ConsoleHandler;
import core.basesyntax.handler.Handler;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        System.out.println("Please, enter 'value' and 'risk' for your bets.");
        Handler consoleHandler = null;
        try {
            consoleHandler = (ConsoleHandler) Injector
                    .getInstance(ConsoleHandler.class);
        } catch (NoAnnotationsExceptions e) {
            System.out.println(e.getMessage());
        }
        if (consoleHandler != null) {
            consoleHandler.handle();
        }
    }
}
