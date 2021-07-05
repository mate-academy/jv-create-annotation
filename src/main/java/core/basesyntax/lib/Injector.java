package core.basesyntax.lib;

import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.exception.FieldHasNoDaoAnnotationException;
import core.basesyntax.factrory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, FieldHasNoDaoAnnotationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getAnnotation(Dao.class) != null) {
                    throw new FieldHasNoDaoAnnotationException("Field" + field.toString() + "has no @Dao annotation");
                }
                if (field.getDeclaringClass().equals(UserDaoImpl.class)) {
                    field.set(instance, Factory.getUserDao());
                } else if (field.getDeclaringClass().equals(BetDaoImpl.class)) {
                    field.set(instance, Factory.getBetDao());
                }
            }
        }
        return null;
    }
}
