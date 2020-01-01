package core.basesyntax.lib;

import core.basesyntax.dao.CustomDaoClass;
import core.basesyntax.exceptions.AnnotationMismatchException;
import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.factory.AnotherBetDaoFactory;
import core.basesyntax.factory.BetDaoFactory;
import java.lang.reflect.Field;

public class Injector {
    public static void inject() throws IllegalAccessException, AnnotationMismatchException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoImpClass = BetDaoImpl.class;
        Class<CustomDaoClass> customDaoClass = CustomDaoClass.class;

        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();

        for (Field elem : consoleHandlerFields) {
            System.out.println(elem + " : " + elem.getAnnotatedType());
            if (elem.getDeclaredAnnotation(Inject.class) != null && elem.getType().equals(BetDao.class)) {
                if (betDaoImpClass.isAnnotationPresent(Dao.class)) {
                    elem.setAccessible(true);
                    elem.set(null, BetDaoFactory.getBetDao());
                } else {
                    throw new AnnotationMismatchException();
                }
            }
            if (elem.getDeclaredAnnotation(Inject.class) != null && elem.getType().equals(CustomDaoClass.class)) {
                if (customDaoClass.isAnnotationPresent(Dao.class)) {
                    elem.setAccessible(true);
                    elem.set(null, AnotherBetDaoFactory.getBetDao());
                } else {
                    throw new AnnotationMismatchException();
                }
            }
        }
    }
}
