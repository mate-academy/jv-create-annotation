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

        for (Field elem : consoleHandlerFields) {
            if (elem.getDeclaredAnnotation(Inject.class) != null
                    && elem.getType().equals(BetDao.class)) {
                if (betDaoImpClass.isAnnotationPresent(Dao.class)) {
                    elem.setAccessible(true);
                    elem.set(null, BetDaoFactory.getBetDao());
                } else {
                    throw new AnnotationMismatchException();
                }
            }
            if (elem.getDeclaredAnnotation(Inject.class) != null
                    && elem.getType().equals(PersonDao.class)) {
                if (personDao.isAnnotationPresent(Dao.class)) {
                    elem.setAccessible(true);
                    elem.set(null, PersonDaoFactory.getPersonDao());
                } else {
                    throw new AnnotationMismatchException();
                }
            }
        }
    }
}
