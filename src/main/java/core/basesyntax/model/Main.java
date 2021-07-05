package core.basesyntax.model;

import core.basesyntax.model.controller.ConsoleHandler;
import core.basesyntax.model.dao.BetDao;
import core.basesyntax.model.dao.BetDaoImpl;
import core.basesyntax.model.dao.UserDao;
import core.basesyntax.model.dao.UserDaoImpl;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();
        System.out.println("Enter value and risk for your bet.");
        handler.handle();

        BetDao betDao = new BetDaoImpl();
        UserDao userDao = new UserDaoImpl();
        System.out.println("all bets " + betDao.getAll()
                + "\n" + "all users" + userDao.getAll());
    }
}
