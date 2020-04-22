package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {

        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Enter your name and age, your bet value and risk");
        handler.handle();
        PersonDao personDao = Factory.getPersonDao();
        BetDao betDao = Factory.getBetDao();
        System.out.println("All people: " + personDao.getPeople());
        System.out.println("All bets " + betDao.getAll());
    }
}
