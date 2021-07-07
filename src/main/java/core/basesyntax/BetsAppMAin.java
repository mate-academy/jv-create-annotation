package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.library.Injector;
import java.lang.reflect.InvocationTargetException;

public class BetsAppMAin {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        ((ConsoleHandler) Injector.getInstance(ConsoleHandler.class)).handle();
    }
}
