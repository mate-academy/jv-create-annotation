package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();
        System.out.println("Please enter your bet amount and its risk. If you wantек stop, enter Q.");
        handler.handle();
    }
}
