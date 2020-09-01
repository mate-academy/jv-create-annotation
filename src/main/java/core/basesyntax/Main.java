package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.exceptions.NoAnnotationException;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, NoAnnotationException {
        System.out.println("Enter value and risk of your bet");
        ConsoleHandler consoleHandler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        consoleHandler.handle();
        BetDao betDao = Factory.getBetDao();
        UserDao userDao = Factory.getUserDao();
        System.out.println("All bets: " + betDao.getAll());
        System.out.println("All users: " + userDao.getAll());
    }
}
