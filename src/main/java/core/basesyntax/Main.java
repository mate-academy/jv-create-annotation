package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.mylibrary.Injector;

public class Main {
    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ConsoleHandler.userInterface();
        System.out.println();
    }

}
