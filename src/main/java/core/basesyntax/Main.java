package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        System.out.println("Type your bet and risk ");
        ConsoleHandler handler = new ConsoleHandler();
        handler.handle();
    }
}
