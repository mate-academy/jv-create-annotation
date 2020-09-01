package core.basesyntax.library;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.exception.MissingAnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)
                        && hasDaoAnnotation(Factory.getBetDao().getClass())) {
                    field.set(instance, Factory.getBetDao());
                }
                if (field.getType().equals(UserDao.class)
                        && hasDaoAnnotation(Factory.getUserDao().getClass())) {
                    field.set(instance, Factory.getUserDao());
                }
            }
        }
        return instance;
    }

    private static boolean hasDaoAnnotation(Class clazz) {
        if (clazz.isAnnotationPresent(Dao.class)) {
            return true;
        }
        throw new MissingAnnotationException("Missing DAO annotation");
    }
}
