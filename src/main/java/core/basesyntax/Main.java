package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.CatDao;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConsoleHandler handler =
                (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Enter value and risk for your bet and the cat name that made a bet:");
        handler.handle();
        BetDao betDao = Factory.getBetDao();
        CatDao catDao = Factory.getCatDao();
        System.out.println("all bets: " + betDao.getAll());
        System.out.println("all cats: " + catDao.getAll());
    }
}
