package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.GamblerDao;
import core.basesyntax.dao.GamblerDaoImpl;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.GamblerDaoFactory;

import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consolerHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoImplClass = BetDaoImpl.class;
        Class<GamblerDaoImpl> gambalerDaoImplClass = GamblerDaoImpl.class;

        Field[] consolerHandFields = consolerHandlerClass.getDeclaredFields();

        for (Field field : consolerHandFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType() == BetDao.class
                    && betDaoImplClass.getDeclaredAnnotation(Dao.class) != null) {
                field.setAccessible(true);
                field.set(null, BetDaoFactory.getBetDao());
            }
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType() == GamblerDao.class
                    && gambalerDaoImplClass.getDeclaredAnnotation(Dao.class) != null) {
                field.setAccessible(true);
                field.set(null, GamblerDaoFactory.getUserDao());
            }
        }
    }
}
