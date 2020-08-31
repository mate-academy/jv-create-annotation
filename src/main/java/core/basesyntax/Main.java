package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;

public class Main {

    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler(new BetDao());
        System.out.println("Enter value and risk for your bet");
        handler.handler();
    }
}
