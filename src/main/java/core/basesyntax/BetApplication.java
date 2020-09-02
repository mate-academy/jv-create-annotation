package core.basesyntax;

import core.basesyntax.console.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.DaoException;
import core.basesyntax.factory.Factory;
import core.basesyntax.library.Injector;
import java.lang.reflect.InvocationTargetException;

public class BetApplication {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException,
            DaoException, IllegalAccessException {
        ConsoleHandler handler = (ConsoleHandler) Injector
                .getInstance(ConsoleHandler.class);
        System.out.println("Please enter Name, Surname, Age, Bet value "
                + "and bet risk split by space. if no more bets - q");
        handler.readConsole();
        BetDao betDao = Factory.getBetDao();
        System.out.println("bets" + betDao.getAll());
    }
}
