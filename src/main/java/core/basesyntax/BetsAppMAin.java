package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class BetsAppMAin {
    public static final ConsoleHandler CONSOLE_HANDLER = new ConsoleHandler();

    public static void main(String[] args) {
        System.out.println("Please enter your value and risk for your bet");
        CONSOLE_HANDLER.handle();
    }
}
