package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class BetsAppMAin {

    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        System.out.println("Please enter your value and risk for your bet, or 'q' for exit");
        consoleHandler.handle();
    }
}
