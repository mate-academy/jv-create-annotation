package core.basesyntax;

import core.basesyntax.handler.ConsoleHandler;
import core.basesyntax.handler.Handler;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        System.out.println("Please, enter 'value' and 'risk' for your bets.");
        Handler consoleHandler = (ConsoleHandler) Injector
                .getInstance(ConsoleHandler.class);
        if (consoleHandler != null) {
            consoleHandler.handle();
        }
    }
}
