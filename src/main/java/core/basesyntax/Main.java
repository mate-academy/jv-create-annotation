package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.lib.AbsentDaoAnnotationException;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, AbsentDaoAnnotationException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Enter your bet amount and its risk. "
                + "To exit, press \'Q\'.");
        handler.handle();
    }
}
