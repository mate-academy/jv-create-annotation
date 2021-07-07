package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImp;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImp;
import core.basesyntax.lib.Injector;

public class Main {
    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter user name, age, risk and bet with a whitespace");
        ConsoleHandler.handle();
        BetDao betDao = new BetDaoImp();
        UserDao userDao = new UserDaoImp();
        System.out.println(betDao.getAll());
        System.out.println(userDao.getAll());
    }
}
