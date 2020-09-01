package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.exception.MyException;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException, MyException {
        ConsoleHandler handler = (ConsoleHandler) Injector
                .getInstance(ConsoleHandler.class);
        System.out.println("Please choose type of data: bet or order");
        handler.handle();
    }
}
