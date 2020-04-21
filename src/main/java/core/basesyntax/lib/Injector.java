package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.factory.Factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Injector {

    public static Object getInstance(Class clazz) throws IllegalAccessException,
            InvocationTargetException, InstantiationException,
            NoSuchMethodException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                for (Method method : Factory.class.getDeclaredMethods()) {
                    if (field.getType() == method.getReturnType()) {
                        Object methodReturn = method.invoke(null);
                        if (methodReturn.getClass().isAnnotationPresent(Dao.class)) {
                            field.set(instance, methodReturn);
                        }
                    }
                }
            }
        }

        return instance;
    }
}
