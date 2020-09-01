package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.exception.NonAnnotationException;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, NonAnnotationException {
        ConsoleHandler handler = (ConsoleHandler) Injector
                .getInstance(ConsoleHandler.class);
        System.out.println("Введите value и risk для вашей ставки:");
        handler.handle();
    }
}
