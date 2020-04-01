package core.basesyntax;

import core.basesyntax.conroller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.PlayerDao;
import core.basesyntax.dao.PlayerDaoImpl;
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
        ConsoleHandler.handle();
        BetDao betDao = new BetDaoImpl();
        PlayerDao playerDao = new PlayerDaoImpl();
        System.out.println(betDao.getAll());
        System.out.println(playerDao.getAll());
    }
}
