package core.basesyntax;

import core.basesyntax.handler.ConsoleHandler;
import core.basesyntax.handler.Handler;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please, enter 'value' and 'risk' for your bets.");
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.handle();
    }
}
