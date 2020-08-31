package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class MainApp {
    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.handle();
    }
}
