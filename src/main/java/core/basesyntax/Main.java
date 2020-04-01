package core.basesyntax;

import controller.ConsoleHandler;
import dao.BetDao;
import dao.BetDaoImpl;
import dao.HumanDao;
import dao.HumanDaoImpl;
import lib.Injector;

public class Main {

    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Input value, risk, "
                + "name and amount of money, that you planing to loose");
        ConsoleHandler.handle();
        BetDao betDao = new BetDaoImpl();
        HumanDao humanDao = new HumanDaoImpl();

        System.out.println(betDao.getAll());
        System.out.println(humanDao.getAll());
    }
}
