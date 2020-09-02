package core.basesyntax.lib;

import core.basesyntax.dao.interfaces.BetDao;
import core.basesyntax.dao.interfaces.UserDao;
import core.basesyntax.exception.FieldHasNoDaoAnnotationException;
import core.basesyntax.factrory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class<?> clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, FieldHasNoDaoAnnotationException {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        if (!Factory.getBetDao().getClass().isAnnotationPresent(Dao.class)
                || !Factory.getUserDao().getClass().isAnnotationPresent(Dao.class)) {
            throw new FieldHasNoDaoAnnotationException("No @Dao annotation");
        }
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)) {
                    field.set(instance, Factory.getBetDao());
                }
                if (field.getType().equals(UserDao.class)) {
                    field.set(instance, Factory.getUserDao());
                }
            }
        }
        return instance;
    }
}
