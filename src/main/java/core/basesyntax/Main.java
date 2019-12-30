package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.library.Injector;

public class Main {
    static {
        try {
            Injector.injectDependecy();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello!\nPlease enter your bet"
                + ":(value 'x' /space/ risk 'y.y');"
                + "\nEnter '0' to finish;");
        ConsoleHandler.handle();
        BetDao betDao = new BetDaoImpl();
        System.out.println(betDao.getAll());
    }
}
