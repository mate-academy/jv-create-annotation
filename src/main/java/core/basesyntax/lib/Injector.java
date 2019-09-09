package core.basesyntax.lib;

import core.basesyntax.dao.AnimalDao;
import core.basesyntax.dao.AnimalDaoFactory;
import core.basesyntax.dao.AnimalDaoImpl;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoFactory;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.handlers.ConsoleHandler;
import java.lang.reflect.Field;
import java.util.Scanner;

public class Injector {
    public static void injectDependency() throws IllegalAccessException {
        Field[] consoleHandlerFields = ConsoleHandler.class.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType() == BetDao.class
                    && BetDaoImpl.class.getDeclaredAnnotation(Dao.class) != null) {
                field.setAccessible(true);
                field.set(null, BetDaoFactory.getBetDao());
            }
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType() == AnimalDao.class
                    && AnimalDaoImpl.class.getDeclaredAnnotation(Dao.class) != null) {
                field.setAccessible(true);
                field.set(null, AnimalDaoFactory.getAnimalDao());
            }
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && field.getType() == Scanner.class) {
                field.setAccessible(true);
                field.set(null, new Scanner(System.in));
            }
        }
    }
}