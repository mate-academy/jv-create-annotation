package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDaoImpl;

public class Application {
    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler(new BetDaoImpl(), new UserDaoImpl());
        consoleHandler.handle();
    }
}
