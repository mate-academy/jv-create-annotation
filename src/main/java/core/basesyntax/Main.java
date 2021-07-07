package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.exceptions.NoSuchImplementationException;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, NoSuchImplementationException {
        ConsoleHandler handler = (ConsoleHandler)Injector
                .getInstance(ConsoleHandler.class);
        System.out.print("Please enter value, risk for your bet and your age: ");
        handler.handle();

        BetDao betDao = Factory.getBetDao();
        UserDao userDao = Factory.getUserDao();
        System.out.println("All bets: " + betDao.getAll());
        System.out.println("All ages: " + userDao.getAll());
    }
}
