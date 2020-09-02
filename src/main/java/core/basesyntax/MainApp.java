package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.lib.Injector;
import core.basesyntax.lib.NoImplementationException;
import java.lang.reflect.InvocationTargetException;

public class MainApp {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, NoImplementationException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Enter your name, age and bet's data (e.g. John;31;100;8.4)");
        handler.handle();
    }
}
