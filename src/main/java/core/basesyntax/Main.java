package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException {
        //ConsoleHandler handler = new ConsoleHandler();
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Введіть value та risk для вашої вставки");
        handler.handle();

        BetDao betDao = Factory.getBetDao();
        PersonDao personDao = Factory.getPersonDao();
        System.out.println("persons" + personDao.getAll());
        System.out.println("all bets " + betDao.getAll());
    }
}
