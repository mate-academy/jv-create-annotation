package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.getAnnotation(Inject.class)
                    != null && field.getType().equals(BetDao.class)) {
                if (Factory.getBetDao().getClass().getAnnotationsByType(Dao.class) == null) {
                    throw new NoDaoAnnotationException("No Dao implementation "
                            + "in implemented classes");
                }
                field.setAccessible(true);
                field.set(instance, Factory.getBetDao());
            }
            if (field.getAnnotation(Inject.class)
                    != null && field.getType().equals(PersonDao.class)) {
                if (Factory.getPersonDao().getClass().getAnnotationsByType(Dao.class) == null) {
                    throw new NoDaoAnnotationException("No Dao implementation "
                            + "in implemented classes");
                }
                field.setAccessible(true);
                field.set(instance, Factory.getPersonDao());
            }
        }
        return instance;
    }
}
