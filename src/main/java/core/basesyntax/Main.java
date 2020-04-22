package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PearsonDao;
import core.basesyntax.exceptions.NoSuchImplementationException;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, NoSuchImplementationException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Please enter value and risk for your Bet and your car model");
        handler.handle();

        BetDao betDao = Factory.getBetDao();
        PearsonDao pearsonDao = Factory.getPearsonDao();
        System.out.println("all bets" + betDao.getAll());
        System.out.println("All people " + pearsonDao.getAll());
    }
}
