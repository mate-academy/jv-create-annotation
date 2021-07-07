package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.exception.DaoNotSuchException;
import core.basesyntax.factory.Factory;
import core.basesyntax.library.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, DaoNotSuchException {

        ConsoleHandler handler = (ConsoleHandler) Injector
                .getInstance(ConsoleHandler.class);
        handler.handle();

        BetDao betDao = Factory.getBetDao();
        System.out.println("all bets: " + betDao.getAll());

        PersonDao personDao = Factory.getPersonDao();
        System.out.println("all persons: " + personDao.getAll());
    }
}
