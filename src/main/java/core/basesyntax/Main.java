package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();
        System.out.println("Print 'value, risk' for your bet."
                + "For quit type 'quit'.");
        handler.handle();
    }
}
