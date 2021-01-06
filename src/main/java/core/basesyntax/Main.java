package core.basesyntax;

import core.basesyntax.handler.BetConsoleHandler;
import core.basesyntax.handler.FruitConsoleHandler;
import core.basesyntax.handler.Handler;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please, enter 'value' and 'risk' for your bets.");
        Handler consoleHandlerBet = new BetConsoleHandler();
        consoleHandlerBet.handler();

        System.out.println("Please, enter 'value' and 'risk' for your fruits.");
        Handler consoleHandlerFruits = new FruitConsoleHandler();
        consoleHandlerFruits.handler();
    }
}
