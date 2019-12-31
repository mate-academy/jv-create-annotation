package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.GamerDao;
import core.basesyntax.dao.GamerDaoImpl;
import core.basesyntax.exception.AnnotationNotFoundException;
import core.basesyntax.factories.BetDaoFactory;
import core.basesyntax.factories.GamerDaoFactory;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency()
            throws IllegalAccessException, AnnotationNotFoundException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoImplClass = BetDaoImpl.class;
        Class<GamerDaoImpl> gamerDaoImplClass = GamerDaoImpl.class;

        Field[] consoleHandlerClassDeclaredFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerClassDeclaredFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType().equals(BetDao.class)) {
                if (betDaoImplClass.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(null, BetDaoFactory.getBetDao());
                } else {
                    throw new AnnotationNotFoundException();
                }
            }
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType().equals(GamerDao.class)) {
                if (gamerDaoImplClass.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(null, GamerDaoFactory.getGamerDao());
                } else {
                    throw new AnnotationNotFoundException();
                }
            }
        }
    }
}
