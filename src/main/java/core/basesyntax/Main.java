package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.PlayerDao;
import core.basesyntax.dao.PlayerDaoImpl;
import core.basesyntax.lib.Injector;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {

    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Please write the name and bank of your player\n"
                + "and also bet and risk all separated with whitespaces");
        System.out.println("\nname bank bet risk");
        ConsoleHandler.handle();
        BetDao betDao = new BetDaoImpl();
        PlayerDao playerDao = new PlayerDaoImpl();
        System.out.println(betDao.getAll());
        System.out.println(playerDao.getAll());
    }

}
