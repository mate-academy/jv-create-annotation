package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.OrderDao;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConsoleHandler handler = (ConsoleHandler) Injector
                .getInstance(ConsoleHandler.class);
        System.out.println("Please choose type of data: bet or order");
        handler.handle();
        BetDao betDao = Factory.getBetDao();
        System.out.println("All bets: " + betDao.addAll());
        OrderDao orderDao = Factory.getOrderDao();
        System.out.println("All orders: " + orderDao.addAll());
    }
}
