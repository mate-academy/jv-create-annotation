package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.factory.Factory;
import core.basesyntax.library.Injector;
import core.basesyntax.library.NoAnnotationException;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, NoAnnotationException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Enter value, risk and your name");
        handler.handle();

        BetDao betDao = Factory.getBetDao();
        System.out.println(betDao.getAll());

        UserDao userDao = Factory.getUserDao();
        System.out.println(userDao.getAll());
    }
}
