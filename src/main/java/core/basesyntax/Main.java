package core.basesyntax;

import controller.ConsoleHandler;
import java.lang.reflect.InvocationTargetException;
import lib.Injector;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConsoleHandler handler = (ConsoleHandler) Injector
                .getInstance(ConsoleHandler.class);
        handler.handle();
    }
}
