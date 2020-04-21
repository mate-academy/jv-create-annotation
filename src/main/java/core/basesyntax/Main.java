package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.factory.Factory;
import core.basesyntax.library.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Enter value, risk and your name");
        handler.handle();

        System.out.println();
        System.out.println();

        BetDao betDao = Factory.getBetDao();
        System.out.println(betDao.getAll());

        UserDao userDao = Factory.getUserDao();
        System.out.println(userDao.getAll());
    }
}
