package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImplementation;
import core.basesyntax.dao.PlayerDao;
import core.basesyntax.dao.PlayerDaoImplementation;
import core.basesyntax.lib.Injector;

import java.util.zip.DataFormatException;

public class Main {
    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException | DataFormatException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(" input player name and money amount\n"
                + " input bet and risk value");
        ConsoleHandler.handle();
        PlayerDao playerDao = new PlayerDaoImplementation();
        BetDao betDao = new BetDaoImplementation();
        System.out.println(playerDao.getAll());
        System.out.println(betDao.getAll());
    }
}
