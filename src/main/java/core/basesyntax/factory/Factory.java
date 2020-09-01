package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.OrderDao;
import core.basesyntax.dao.OrderDaoImpl;

public class Factory {
    private static BetDao betDao;
    private static OrderDao orderDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            betDao = new BetDaoImpl();
        }
        return betDao;
    }

    public static OrderDao getOrderDao() {
        if (orderDao == null) {
            orderDao = new OrderDaoImpl();
        }
        return orderDao;
    }
}
