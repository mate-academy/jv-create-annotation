package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.PersonDaoFactory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        handler.handle();

        BetDao betDao = BetDaoFactory.getBetDao();
        System.out.println("All bets: " + betDao.getAll());

        PersonDao personDao = PersonDaoFactory.getPersonDao();
        System.out.println("All persons: " + personDao.getAll());
    }
}
