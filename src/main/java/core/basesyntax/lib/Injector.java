package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.dao.PersonDaoImpl;
import core.basesyntax.exception.AnnotationNotFoundException;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.PersonDaoFactory;

import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType().equals(BetDao.class)) {
                if (BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(null, BetDaoFactory.getBetDao());
                } else {
                    throw new AnnotationNotFoundException();
                }
            }
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType().equals(PersonDao.class)) {
                if (PersonDaoImpl.class.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(null, PersonDaoFactory.getPersonDao());
                } else {
                    throw new AnnotationNotFoundException();
                }
            }
        }
    }
}
