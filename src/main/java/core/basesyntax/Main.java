package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.HumanDaoFactory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Enter your age, name, value and risk for your bet");
        System.out.println("To exit press 'q'");
        handler.handle();

        BetDao betDao = BetDaoFactory.getBetDao();
        System.out.println("All bets: " + betDao.getAll());
        HumanDao humanDao = HumanDaoFactory.getHumanDao();
        System.out.println("All humans: " + humanDao.getAll());
    }
}
