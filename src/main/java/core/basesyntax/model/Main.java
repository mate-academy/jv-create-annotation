package core.basesyntax.model;

import core.basesyntax.model.controller.ConsoleHandler;
import core.basesyntax.model.dao.BetDaoImpl;
import core.basesyntax.model.dao.GenericDao;
import core.basesyntax.model.dao.UserDaoImpl;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();
        System.out.println("Enter value and risk for your bet.");
        handler.handle();

        GenericDao betDao = new BetDaoImpl();
        GenericDao userDao = new UserDaoImpl();
        System.out.println("all bets " + betDao.getAll()
                + "\n" + "all users" + userDao.getAll());
    }
}
