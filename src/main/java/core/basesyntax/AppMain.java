package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class AppMain {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();
        System.out.println("Enter your bet in format \"bet_value risk\"");
        handler.handle();
    }
}
