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
        Class<BetDaoImpl> betDaoImplClass = BetDaoImpl.class;
        Class<PlayerDaoImpl> playerDaoImplClass = PlayerDaoImpl.class;

        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                if (field.getType().equals(BetDao.class)) {
                    if (betDaoImplClass.getDeclaredAnnotation(Dao.class) != null) {
                        field.setAccessible(true);
                        field.set(null, BetDaoFactory.getBetDao());
                    } else {
                        System.out.println("BetDao hasn't been found");
                    }
                }
                if (field.getType().equals(PlayerDao.class)) {
                    if (playerDaoImplClass.getDeclaredAnnotation(Dao.class) != null) {
                        field.setAccessible(true);
                        field.set(null, PlayerDaoFactory.getPlayerDao());
                    } else {
                        System.out.println("BetDao hasn't been found");
                    }
                }
            }
        }
    }
}
