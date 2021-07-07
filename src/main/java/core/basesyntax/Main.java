package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.exceptions.NotSuchAnnotationException;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, NotSuchAnnotationException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        handler.handle();
    }
}
