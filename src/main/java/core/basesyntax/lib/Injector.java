package core.basesyntax.lib;

import core.basesyntax.exceptions.AnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class getClass)
            throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Constructor constructor = getClass.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] fields = getClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dao = Factory.getDao(field.getType());
                if (dao.getClass().isAnnotationPresent(Dao.class)) {
                    field.set(instance, dao);
                } else {
                    throw new AnnotationException("Annotation @Dao doesn't exist in the "
                            + field.getAnnotatedType().getType());
                }
            }
        }
        return instance;
    }
}
