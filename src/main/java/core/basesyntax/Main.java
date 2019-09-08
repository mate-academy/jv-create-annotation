package core.basesyntax;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.handlers.ConsoleHandler;
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
        ConsoleHandler.handle(BetDao.class.getName());
        BetDao betDao = new BetDaoImpl();
        System.out.println(betDao.getAll());
    }
}