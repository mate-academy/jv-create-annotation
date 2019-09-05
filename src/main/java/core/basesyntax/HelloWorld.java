package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.dao.HumanDaoImpl;
import core.basesyntax.lib.Injector;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter value and risk and name: ");
        ConsoleHandler.handle();
        BetDao betDao = new BetDaoImpl();
        HumanDao humanDao = new HumanDaoImpl();
        System.out.println(betDao.getAll());
        System.out.println(humanDao.getAll());
    }
}
