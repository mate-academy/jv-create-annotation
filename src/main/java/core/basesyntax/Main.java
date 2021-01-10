package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        //ConsoleHandler consoleHandler = new ConsoleHandler();
        ConsoleHandler consoleHandler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Введіть value та risk ля вашої ставки");
        consoleHandler.handle();

        BetDao betDao = Factory.getBetDao();
        System.out.println("all bets: " + betDao.getAll());
    }
}
