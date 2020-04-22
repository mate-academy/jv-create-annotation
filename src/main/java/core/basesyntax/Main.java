package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.exceptions.NoDaoException;
import core.basesyntax.exceptions.NoInjectException;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, NoInjectException, NoDaoException {
        System.out.println("Enter your name, age, value and risk for your bet");
        System.out.println("q - to exit");
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        handler.handler();
        BetDao betDao = Factory.getBetDao();
        System.out.println("All bets: " + betDao.getAll());
        HumanDao humanDao = Factory.getHumanDao();
        System.out.println("All humans: " + humanDao.getAll());
    }
}
