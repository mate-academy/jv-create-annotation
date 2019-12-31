package core.basesyntax.src;

import core.basesyntax.src.controller.ConsoleHandler;
import core.basesyntax.src.dao.BetDao;
import core.basesyntax.src.dao.BetDaoImpl;
import core.basesyntax.src.dao.PlayerDao;
import core.basesyntax.src.dao.PlayerDaoImpl;
import core.basesyntax.src.lib.Injector;

public class Main {

    static {
        try {
            Injector.injectDependency();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Enter player name, age, bet and risk separated by space.");
        ConsoleHandler.handle();
        BetDao betDao = new BetDaoImpl();
        System.out.println(betDao.getAll());
        PlayerDao playerDao = new PlayerDaoImpl();
        System.out.println(playerDao.getAll());
    }
}
