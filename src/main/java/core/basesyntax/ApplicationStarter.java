package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class ApplicationStarter {
    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        System.out.println("Enter value and risk for your bet:");
        consoleHandler.handler();
    }
}
