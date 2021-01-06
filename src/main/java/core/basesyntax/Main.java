package core.basesyntax;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.handler.BetConsoleHandler;
import core.basesyntax.handler.FruitConsoleHandler;
import core.basesyntax.handler.Handler;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Fruit;
import java.util.List;

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
