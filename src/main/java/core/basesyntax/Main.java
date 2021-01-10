package core.basesyntax;

import core.basesyntax.controller.ControllerHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws
            InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        ControllerHandler controllerHandler = (ControllerHandler) Injector
                .getInstance(ControllerHandler.class);
        System.out.println("Enter your Name and Nickname!");
        controllerHandler.handle();
        UserDao userDao = Factory.getUserDao();
        BetDao betDao = Factory.getBetDao();
        System.out.println(betDao.getBets());
        System.out.println(userDao.getUsers());
    }
}
