package core.basesyntax.lib;

import core.basesyntax.factory.DaoFactory;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    private DaoFactory factory;

    public Injector(DaoFactory factory) {
        this.factory = factory;
    }

    public <T> T getInstance(Class<T> clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        T obj = clazz.getDeclaredConstructor().newInstance();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().getAnnotation(Dao.class) != null) {
                    field.set(obj, factory.getDao(field.getType()));
                }
            }
        }
        return obj;
    }
}
