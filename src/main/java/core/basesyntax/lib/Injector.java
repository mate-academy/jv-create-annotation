package core.basesyntax.lib;

import core.basesyntax.controllers.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImp;
import core.basesyntax.dao.LotteryDao;
import core.basesyntax.dao.LotteryDaoImp;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.LotteryDaoFactory;

import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImp> betDaoImpClass = BetDaoImp.class;
        Class<LotteryDaoImp> lotteryDaoImpClass = LotteryDaoImp.class;

        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field consoleHandlerField : consoleHandlerFields) {
            if (consoleHandlerField.getDeclaredAnnotation(Inject.class) != null
                    && betDaoImpClass.getDeclaredAnnotation(Dao.class) != null
                    && consoleHandlerField.getType() == BetDao.class) {
                consoleHandlerField.setAccessible(true);
                consoleHandlerField.set(null, BetDaoFactory.getBetDao());
            }
            if (consoleHandlerField.getDeclaredAnnotation(Inject.class) != null
                    && lotteryDaoImpClass.getDeclaredAnnotation(Dao.class) != null
                    && consoleHandlerField.getType() == LotteryDao.class) {
                consoleHandlerField.setAccessible(true);
                consoleHandlerField.set(null, LotteryDaoFactory.getLotteryDao());
            }
        }
    }
}
