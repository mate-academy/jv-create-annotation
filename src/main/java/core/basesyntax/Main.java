package core.basesyntax;

import core.basesyntax.handler.BetConsoleHandler;
import core.basesyntax.handler.Handler;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please, enter 'value' and 'risk' for your bets.");
        Handler consoleHandlerBet = new BetConsoleHandler();
        consoleHandlerBet.handle();
    }
}
