package core.basesyntax.src.lib;

import core.basesyntax.src.controller.ConsoleHandler;
import core.basesyntax.src.dao.BetDao;
import core.basesyntax.src.dao.BetDaoImpl;
import core.basesyntax.src.dao.PlayerDao;
import core.basesyntax.src.dao.PlayerDaoImpl;
import core.basesyntax.src.factory.BetDaoFactory;
import core.basesyntax.src.factory.PlayerDaoFactory;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws Exception {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;
        Class<PlayerDaoImpl> playerDaoClass = PlayerDaoImpl.class;
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType().equals(BetDao.class)
                    && betDaoClass.getDeclaredAnnotation(Dao.class) != null) {
                field.setAccessible(true);
                field.set(null, BetDaoFactory.getDao());
            }
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType().equals(PlayerDao.class)
                    && playerDaoClass.getDeclaredAnnotation(Dao.class) != null) {
                field.setAccessible(true);
                field.set(null, PlayerDaoFactory.getDao());
            }
        }
    }
}
