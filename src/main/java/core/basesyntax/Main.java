package core.basesyntax;

import core.basesyntax.consoler.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.exeption.DaoModelNullException;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args)
            throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, DaoModelNullException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Enter your name, age, rate and risk");
        handler.handle();
        BetDao betDao = Factory.getBetDao();
        PersonDao personDao = Factory.getPersonDao();
        System.out.println("All bets: " + betDao.getAll());
        System.out.println("All data about people: " + personDao.getAll());
    }
}
