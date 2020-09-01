package core.basesyntax.model;

import core.basesyntax.model.controller.ConsoleHandler;
import core.basesyntax.model.dao.BetDao;
import core.basesyntax.model.dao.UserDao;
import core.basesyntax.model.factory.Factory;
import core.basesyntax.model.lib.Injector;
import core.basesyntax.model.lib.NoDaoAnnotationException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, NoDaoAnnotationException,
            ArrayIndexOutOfBoundsException {

        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        handler.handle();

        BetDao betDao = Factory.getBetDao();
        UserDao userDao = Factory.getUserDao();
        System.out.println("all bets " + betDao.getAll()
                + "\n" + "all users" + userDao.getAll());
    }
}
