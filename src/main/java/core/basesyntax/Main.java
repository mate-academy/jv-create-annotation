package core.basesyntax;

import core.basesyntax.Controller.ConsolHandler;
import core.basesyntax.Exception.NoDaoImplException;
import core.basesyntax.Factory.Factory;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.lib.Injector;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException, NoDaoImplException {
        ConsolHandler handler =(ConsolHandler) Injector.getInstance(ConsolHandler.class);
        System.out.println("Введите сумму, коэффициент ставки, имя и ID ");
        handler.handler();
        BetDao betDao = Factory.getBetDao();
        UserDao userDao = Factory.getUserDao();
        System.out.println("all bets: " + betDao.getAll());
        System.out.println("all users: " + userDao.getAll());
    }
}
