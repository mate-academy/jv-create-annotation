package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;

import core.basesyntax.dao.GamerDao;
import core.basesyntax.dao.GamerDaoImpl;
import core.basesyntax.lib.Injector;

public class TestMain {

    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Type your age, nickname, your bet and risk. Only using whitspaces");
        ConsoleHandler.handle();
        GamerDao gamerDao = new GamerDaoImpl();
        BetDao betDao = new BetDaoImpl();
        System.out.println(gamerDao.getAll());
        System.out.println(betDao.getAll());
    }
}
