package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();
        System.out.println("Enter your bet amount and its risk. To exit, press \'Q\'.");
        handler.handle();
    }
}
