package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.library.Injector;
import java.lang.reflect.InvocationTargetException;

public class MainApp {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("Hello, dear user!\n"
                + "Are you ready to take risks?\n"
                + "To start with, type in your name, surname, age, "
                + "value of the bet and its risk. Example: \n"
                + "Dariia, Pikul, 24, 100, 4.5\n"
                + "Keep betting or type in \"exit\" for quitting the service");
        ConsoleHandler handler = (ConsoleHandler) Injector
                .getInstance(ConsoleHandler.class);
        handler.handle();
    }
}
