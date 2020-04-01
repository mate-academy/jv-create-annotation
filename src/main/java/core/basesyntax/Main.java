package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.UserDaoFactory;
import core.basesyntax.lib.Injector;

public class Main {
    static {
        try {
            Injector.injectDependecy();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter Name, id, bet, risk:");
        ConsoleHandler.input();
        print();
    }

    public static void print() {
        UserDao userDao = UserDaoFactory.getUserDao();
        BetDao betDao = BetDaoFactory.getBetDao();
        for (int i = 0; i < userDao.getAll().size(); i++) {
            System.out.println(userDao.get(i) + " " + betDao.get(i));
        }
    }
}
