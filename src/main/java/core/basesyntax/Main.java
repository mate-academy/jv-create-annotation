package core.basesyntax;

import controllers.ConsoleHandler;
import dao.BetDao;
import dao.BetDaoImpl;
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
        ConsoleHandler.handle();

        BetDao betDao = new BetDaoImpl();
        System.out.println(betDao.getAll());
    }
}
