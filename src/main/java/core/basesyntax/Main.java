package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        ConsoleHandler handler = (ConsoleHandler) Injector
                .getInstance(ConsoleHandler.class);
        System.out.println("Input value, risk, name and age(e.g. 10 1.5 Ivan 18): ");
        handler.handle();

        BetDao betDao = Factory.getBetDao();
        PersonDao personDao = Factory.getPersonDao();
        System.out.println("All bets: " + betDao.getAll());
        System.out.println("All persons: " + personDao.getAll());
    }
}
