package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.dao.PersonDaoImpl;
import core.basesyntax.exceptions.AnnotationMismatchException;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.PersonDaoFactory;
import java.lang.reflect.Field;

public class Injector {
    public static void inject() throws IllegalAccessException, AnnotationMismatchException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoImpClass = BetDaoImpl.class;
        Class<PersonDaoImpl> personDao = PersonDaoImpl.class;

        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();

        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType().equals(BetDao.class)) {
                if (betDaoImpClass.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(null, BetDaoFactory.getBetDao());
                } else {
                    throw new AnnotationMismatchException();
                }
            }
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType().equals(PersonDao.class)) {
                if (personDao.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(null, PersonDaoFactory.getPersonDao());
                } else {
                    throw new AnnotationMismatchException();
                }
            }
        }
    }
}
