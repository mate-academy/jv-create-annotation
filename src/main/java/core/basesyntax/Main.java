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
        System.out.println("Input name age bet risk separated with spaces");
        handler.handle();

        UserDao userDao = Factory.getUserDao();
        BetDao betDao = Factory.getBetDao();

        System.out.println("all users: " + userDao.getAll());
        System.out.println("all bets: " + betDao.getAll());
    }
}
