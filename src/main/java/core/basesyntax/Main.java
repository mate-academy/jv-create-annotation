package core.basesyntax;

import static core.basesyntax.controller.PrintData.print;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.lib.Injector;

/**
 * Feel free to remove this class and create your own.
 */

public class Main {
    static {
        try {
            Injector.injectDependecy();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter Name, id, bet, risk:");
        ConsoleHandler.input();
        print();
    }
}
