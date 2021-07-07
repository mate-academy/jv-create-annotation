package core.basesyntax;

import controller.ConsoleHandler;
import exceptions.NoDaoAnnotationFound;
import java.lang.reflect.InvocationTargetException;
import lib.Injector;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, NoDaoAnnotationFound {
        ConsoleHandler handler = (ConsoleHandler) Injector
                .getInstance(ConsoleHandler.class);
        System.out.println("Введіть ставку та ризик вашої ставки,"
                + " а також ім'я користовача та кількість його очок");
        handler.handle();
    }
}
