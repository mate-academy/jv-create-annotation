package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.GamblerDao;
import core.basesyntax.dao.GamblerDaoImpl;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.GamblerDaoFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Injector {

    public static void injectDependency() throws IllegalAccessException, InvocationTargetException {
        Field[] consoleHandlerFields = ConsoleHandler.class.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                if (field.getType().equals(BetDao.class)
                        && BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
                    setField(BetDaoFactory.class, field);
                } else if (field.getType().equals(GamblerDao.class)
                        && GamblerDaoImpl.class.isAnnotationPresent(Dao.class)) {
                    setField(GamblerDaoFactory.class, field);
                }
            }
        }
    }

    private static void setField(Class daoFactory, Field field) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = daoFactory.getDeclaredMethods();
        field.setAccessible(true);
        field.set(null, methods[0].invoke(daoFactory));
    }
}
