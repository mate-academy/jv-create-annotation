package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;
import core.basesyntax.lib.NoSuchDaoImplementationException;
import java.lang.reflect.InvocationTargetException;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, NoSuchDaoImplementationException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Введіть значення, ризик, ваше  ім'я та відсоток кешбеку"
                + " для вашої ставики або натисніть Q для виходу ");
        handler.handle();
        BetDao betDao = Factory.getBetDao();
        System.out.println("All bets: " + betDao.getAll());
        PersonDao personDao = Factory.getPersonDao();
        System.out.println("All persons: " + personDao.getAll());
    }

}
