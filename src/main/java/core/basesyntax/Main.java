package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        //System.out.println("Input value and risk for your bet");
        consoleHandler.handle();
    }
}
