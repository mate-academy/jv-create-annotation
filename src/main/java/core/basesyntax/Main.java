package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PlayerDao;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.PlayerDaoFactory;
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
        System.out.println("Input sum coefisient and player name using space");
        ConsoleHandler.handle();
        BetDao betDao = BetDaoFactory.getBetDao();
        PlayerDao playerDao = PlayerDaoFactory.getPlayerDao();
        System.out.println(betDao.getAll());
        System.out.println(playerDao.getAll());
    }
}