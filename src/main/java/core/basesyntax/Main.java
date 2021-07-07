package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDaoImpl;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler(new BetDaoImpl());
        System.out.println("Enter value and risk for your bet");
        handler.handle();
    }
}
