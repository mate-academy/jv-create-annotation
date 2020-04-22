package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.factory.Factory;
import core.basesyntax.library.Injector;
import java.lang.reflect.InvocationTargetException;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {

    public static void main(String [] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        /*ConsoleHandler handler = new ConsoleHandler();*/
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Please enter your bet amount, "
                + "risk value and your bet date, otherwise, please enter 'quit'");
        handler.handler();
        BetDao betDao = Factory.getBetDao();
        System.out.println("All bets" + betDao.getAll());
        UserDao userDao = Factory.getUserDao();
        System.out.println("All users" + userDao.getAll());

    }
}
