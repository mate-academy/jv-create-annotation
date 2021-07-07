package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Enter your name surname value risk");
        handler.handle();
        System.out.println(Factory.getPersonDao().getAll());
    }
}
