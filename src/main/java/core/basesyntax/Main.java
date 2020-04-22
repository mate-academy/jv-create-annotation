package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, ClassNotFoundException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        handler.handle();

        System.out.println("all bets: " + handler.getAll());
    }
}
