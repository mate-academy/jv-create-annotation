package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImplementation;
import core.basesyntax.dao.PlayerDao;
import core.basesyntax.dao.PlayerDaoImplementation;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.PlayerDaoFactory;

import java.lang.reflect.Field;
import java.util.zip.DataFormatException;

public class Injector {

    public static void injectDependency() throws IllegalAccessException, DataFormatException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImplementation> betDaoImplClass = BetDaoImplementation.class;
        Class<PlayerDaoImplementation> playerDaoImplClass = PlayerDaoImplementation.class;

        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getAnnotation(Inject.class) != null && field.getType().equals(BetDao.class)) {
                if (betDaoImplClass.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(null, BetDaoFactory.getBetDao());
                } else {
                    throw new DataFormatException();
                }
            }
            if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(PlayerDao.class)) {
                if (playerDaoImplClass.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(null, PlayerDaoFactory.getPlayerDao());
                } else {
                    throw new DataFormatException();
                }
            }
        }
    }
}
