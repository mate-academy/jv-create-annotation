package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.exceptions.AnnotationMismatchException;
import core.basesyntax.lib.Injector;

public class Main {
    public static void main(String[] args) {
        try {
            Injector.inject();
        } catch (IllegalAccessException | AnnotationMismatchException e) {
            e.printStackTrace();
        }

        System.out.println("Чтобы сделать ставку - введите через пробел сумму и риски. \n");
        ConsoleHandler.handle();
    }
}
