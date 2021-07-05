package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.exception.NoImplementationException;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, NoImplementationException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Please, enter value and risk for your bet and your name,"
                + " or 'q' to exit.");
        handler.handle();

        BetDao betDao = Factory.getBetDao();
        PersonDao personDao = Factory.getPersonDao();
        System.out.println("All bets are: " + betDao.getAll());
        System.out.println("All persons are: " + betDao.getAll());
    }
}
