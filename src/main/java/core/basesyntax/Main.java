package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();
        System.out.println("Please, input value and risk for your bet");
        handler.handle();
    }
}
