package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.library.Injector;
import java.lang.reflect.InvocationTargetException;

public class BetsAppMAin {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        ConsoleHandler consoleHandler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("For registration press 'r' "
                + "\nFor quit press 'q' "
                + "\nFor create bet press 'b'");
        consoleHandler.handle();
    }
}
