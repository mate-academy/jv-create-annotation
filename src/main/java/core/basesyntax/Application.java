package core.basesyntax;

import core.basesyntax.controller.BetConsoleHandler;
import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.controller.UserConsoleHandler;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.GenericDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;

/**
 * Feel free to remove this class and create your own.
 */
public class Application {
    public static void main(String[] args) {
        Storage<User> userStorage = new Storage<>();
        GenericDao<User> userDao = new UserDaoImpl(userStorage);
        ConsoleHandler userConsoleHandler = new UserConsoleHandler(userDao);
        userConsoleHandler.handle();
        for (User user: userDao.getAll()) {
            System.out.println(user.toString());
        }
        System.out.println("---><---");
        Storage<Bet> betStorage = new Storage<>();
        GenericDao<Bet> betDao = new BetDaoImpl(betStorage);
        ConsoleHandler betConsoleHandler = new BetConsoleHandler(betDao);
        betConsoleHandler.handle();
        for (Bet bet: betDao.getAll()) {
            System.out.println(bet.toString());
        }
    }
}
