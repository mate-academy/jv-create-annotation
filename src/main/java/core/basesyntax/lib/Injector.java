package core.basesyntax.lib;

import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {

        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dao = Factory.getDao(field.getClass());
                if (dao.getClass().isAnnotationPresent(Dao.class)) {
                    field.set(instance, dao);
                } else {
                    throw new NoSuchMethodException("Can't inject"
                            + field.getAnnotatedType().getType()
                            + " No such implementation");
                }
            }
        }
        return instance;
    }
}
