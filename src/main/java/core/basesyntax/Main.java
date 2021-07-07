package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Please input your login value and risk for your bet: ");
        handler.handle();

        BetDao betDao = Factory.getBetDao();
        UserDao userDao = Factory.getUserDao();
        System.out.println("all bets: " + betDao.getAll());
        System.out.println("all users: " + userDao.getAll());
    }
}
