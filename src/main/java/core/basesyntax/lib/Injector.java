package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.factory.Factory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws IllegalAccessException,
            NoSuchMethodException, InvocationTargetException, InstantiationException {
        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        Object instance = declaredConstructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (BetDao.class.equals(field.getType())
                && isDao(Factory.getBetDao().getClass())) {
                    field.set(instance, Factory.getBetDao());
                }
                if (UserDao.class.equals(field.getType())
                && isDao(Factory.getUserDao().getClass())) {
                    field.set(instance, Factory.getUserDao());
                }
            }
        }
        return instance;
    }

    private static boolean isDao(Class clazz) {
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation: annotations) {
           return annotation.annotationType().getCanonicalName().equals(Dao.class.getName());
        }
        throw new RuntimeException("DaoIsUnusuable");
    }
}
