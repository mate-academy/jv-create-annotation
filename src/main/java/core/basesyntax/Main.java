package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDaoImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Type your name and age, bet and risk. PRESS 'q' FOR EXIT");
        ConsoleHandler handler = new ConsoleHandler(new BetDaoImpl(), new UserDaoImpl());
        handler.handle();
    }
}
