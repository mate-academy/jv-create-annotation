package core.basesyntax.lib;

import core.basesyntax.dao.ClientDao;
import core.basesyntax.dao.CreditDao;
import core.basesyntax.error.NoSuchAnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Injector {
    private static final String DAO_PACKAGE = "core.basesyntax.dao.";

    public static Object getInstance(Class<?> clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, ClassNotFoundException {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) == null
                    && (field.getType() == CreditDao.class || field.getType() == ClientDao.class)) {
                throw new NoSuchAnnotationException("no 'Inject' annotation was found");
            }

            String daoName = DAO_PACKAGE + field.getType().getSimpleName() + "Impl";
            Class<?> daoClass = Class.forName(daoName);
            if (daoClass.getAnnotation(Dao.class) == null) {
                throw new NoSuchAnnotationException("no 'Dao' annotation was found");
            }

            Method[] factories = Factory.class.getDeclaredMethods();
            for (Method factory : factories) {
                if (factory.getReturnType() == field.getType()) {
                    field.setAccessible(true);
                    field.set(instance, factory.invoke(null));
                }
            }
        }
        return instance;
    }
}
