package core.basesyntax.src.lib;

import core.basesyntax.src.controller.ConsoleHandler;
import core.basesyntax.src.dao.BetDaoImpl;
import core.basesyntax.src.dao.PlayerDaoImpl;
import core.basesyntax.src.factory.BetDaoFactory;
import core.basesyntax.src.factory.PlayerDaoFactory;

import java.lang.reflect.Field;

public class Injector {

    private static Object getDaoSource() throws Exception {
        Object daoSource = null;
        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;
        if (betDaoClass.getDeclaredAnnotation(Dao.class) != null) {
            daoSource = BetDaoFactory.getDao();
        }
        Class<PlayerDaoImpl> playerDaoClass = PlayerDaoImpl.class;
        if (playerDaoClass.getDeclaredAnnotation(Dao.class) != null) {
            daoSource = PlayerDaoFactory.getDao();
        }
        if (daoSource == null) {
            throw new Exception();
        }
        return daoSource;
    }

    public static void injectDependency() throws Exception {

        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                field.set(null, getDaoSource());
            }
        }
    }
}
