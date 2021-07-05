package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.customexceptions.NoDaoAnnotationInTheClass;
import core.basesyntax.customexceptions.NoSuchImplementationException;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args)
            throws NoSuchMethodException, IllegalAccessException,
            InstantiationException, NoSuchImplementationException,
            InvocationTargetException, NoDaoAnnotationInTheClass {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        handler.handle();
    }
}
