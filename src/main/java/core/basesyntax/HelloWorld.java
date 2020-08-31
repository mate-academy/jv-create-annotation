package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        System.out.println("Input your name, age, value and risk for your bet:");
        consoleHandler.handle();
    }
}
