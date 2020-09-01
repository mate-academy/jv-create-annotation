package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        System.out.println("Enter your name, id and value, risk of your bet");
        System.out.println("You can enter a set of bets,"
                + " but don't forget about user data before each bet");
        consoleHandler.handle();
    }
}
