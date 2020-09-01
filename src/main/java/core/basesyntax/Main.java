package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.exeptions.NonAnnotationException;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, NonAnnotationException,
            InstantiationException, IllegalAccessException {
        ConsoleHandler handler = (ConsoleHandler) Injector
                .getInstance(ConsoleHandler.class);
        System.out.println("Введіть ваше ім'я, призвіще, "
                + "сумму та ризик для вашої ставки через пробіл.\n"
                + "Щоб завершити роботу програми натисніть 'q'.");
        handler.handle();
    }
}
