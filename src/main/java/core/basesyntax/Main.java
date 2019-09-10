package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImp;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.dao.HumanDaoImp;
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
        System.out.println("If you are want make bet put bet and risk ,name and age!");
        ConsoleHandler.handle();
        BetDao betDao = new BetDaoImp();
        HumanDao humanDao = new HumanDaoImp();
        System.out.println(betDao.getAll());
        System.out.println(humanDao.getAll());

    }
}
