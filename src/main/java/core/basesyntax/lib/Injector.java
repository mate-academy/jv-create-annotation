package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.GamblerDaoImpl;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.GamblerDaoFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Injector {
    static Class[] dao = {BetDaoImpl.class, GamblerDaoImpl.class};
    static Class[] factory = {BetDaoFactory.class, GamblerDaoFactory.class};
    static int model = 0;

    public static void injectDependency() throws IllegalAccessException, InvocationTargetException {
        Field[] consoleHandlerFields = ConsoleHandler.class.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                setField(dao[model], factory[model], field);
                model++;
            }
        }
    }

    private static void setField(Class daoClass, Class daoFactory, Field field) throws IllegalAccessException, InvocationTargetException {
        if (daoClass.isAnnotationPresent(Dao.class)) {
            for (Class daoInterface : daoClass.getInterfaces()) {
                if (daoInterface.equals(field.getType())) {
                    Method[] methods = daoFactory.getDeclaredMethods();
                    field.set(null, methods[0].invoke(daoFactory));
                    return;
                }
            }
        }
        System.out.println("Ошибка");
        System.exit(0);
    }
}
