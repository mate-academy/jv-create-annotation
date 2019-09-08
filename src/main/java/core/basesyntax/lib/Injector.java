package core.basesyntax.lib;


import core.basesyntax.dao.*;

import core.basesyntax.handlers.ConsoleHandler;

import java.lang.reflect.Field;


public class Injector {
    public static void injectDependency() throws IllegalAccessException {
        Field[] consoleHandlerFields = ConsoleHandler.class.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                if (field.getType() == BetDao.class) {
                    if (BetDaoImpl.class.getDeclaredAnnotation(Dao.class) != null) {
                        field.setAccessible(true);
                        field.set(null, BetDaoFactory.getBetDao());
                        break;
                    }
                }
            }
        }
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                if (field.getType() == AnimalDao.class) {
                    if (AnimalDaoImpl.class.getDeclaredAnnotation(Dao.class) != null) {
                        field.setAccessible(true);
                        field.set(null, AnimalDaoFactory.getAnimalDao());
                        break;
                    }
                }
            }
        }
    }
}