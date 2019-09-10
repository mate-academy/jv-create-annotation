package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.GamblerDao;
import core.basesyntax.dao.GamblerDaoImpl;
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
                + "сумму, риск, имя и id игрока через пробел");

        ConsoleHandler.handle();
        BetDao betDao = new BetDaoImpl();
        GamblerDao gamblerDao = new GamblerDaoImpl();
        System.out.println(betDao.getAll());
        System.out.println(gamblerDao.getAll());
    }
}
