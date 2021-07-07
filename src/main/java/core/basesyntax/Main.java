package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.dao.HumanDaoImpl;
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
        System.out.println("Если хотите сделать ставку, введите \n"
                + "сумму, риск и свое имя через пробел");
        ConsoleHandler.handle();
        BetDao betDao = new BetDaoImpl();
        HumanDao humanDao = new HumanDaoImpl();
        System.out.println(betDao.getAll() + " " + humanDao.getAll());
    }
}
