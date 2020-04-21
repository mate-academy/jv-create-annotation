package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PlayerDao;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException
            , NoSuchMethodException, InstantiationException, IllegalAccessException {

        ConsoleHandler consoleHandler = (ConsoleHandler) Injector
                .getInstance(ConsoleHandler.class);

        BetDao betDao = Factory.getBetDao();
        PlayerDao playerDao = Factory.getPlayerDao();

        while (true) {
            consoleHandler.handle();
            System.out.println("Список ставок:\n" + betDao.getAll());
            System.out.println("Список игроков:\n" + playerDao.getAll());
        }
    }

}
