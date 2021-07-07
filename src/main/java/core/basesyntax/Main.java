package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.lib.Injector;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter your bet and risk. For confirm you need enter your name and age");
        ConsoleHandler.handle();
        BetDao betDao = new BetDaoImpl();
        UserDao userDao = new UserDaoImpl();
        System.out.println(betDao.getAll());
        System.out.println(userDao.getAll());
    }
}
