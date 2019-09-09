package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.PlayerDao;
import core.basesyntax.dao.PlayerDaoImpl;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.PlayerDaoFactory;

import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;
        Class<PlayerDaoImpl> playerDaoClass = PlayerDaoImpl.class;

        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType() == BetDao.class
                    && betDaoClass.getDeclaredAnnotation(Dao.class) != null) {
                field.setAccessible(true);
                field.set(null, BetDaoFactory.getBetDao());
            }
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType() == PlayerDao.class
                    && playerDaoClass.getDeclaredAnnotation(Dao.class) != null) {
                field.setAccessible(true);
                field.set(null, PlayerDaoFactory.getPlayerDao());
            }
        }
    }
}
