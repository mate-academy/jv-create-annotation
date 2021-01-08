package core.basesyntax;

import core.basesyntax.controller.ControllerHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;

public class Main {
    public static void main(String[] args) {
        ControllerHandler controllerHandler = new ControllerHandler();
        System.out.println("Enter your Name and Nickname!");
        controllerHandler.handle();
        BetDao betDao = new BetDaoImpl();
        UserDao userDao = new UserDaoImpl();
        System.out.println(betDao.getBets());
        System.out.println(userDao.getUsers());
    }
}
