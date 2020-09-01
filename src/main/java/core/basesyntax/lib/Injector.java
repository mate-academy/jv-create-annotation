package core.basesyntax.lib;

import core.basesyntax.dao.GenericDao;
import core.basesyntax.factory.AbstractFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(GenericDao.class)) {
                    field.set(instance, AbstractFactory.getNecessaryInstance(clazz));
                } else {
                    throw new RuntimeException("Unknown field type!!!");
                }
            }
        }
        return instance;
    }
}
