package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.exception.NoAnnotationsExceptions;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoAnnotationsExceptions {
        Constructor constructor = clazz.getConstructor();
        Object instance = constructor.newInstance();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                if (field.getType() == BetDao.class
                        && BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getBetDao());
                }
                if (field.getType() == FruitDao.class
                        && FruitDaoImpl.class.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getFruitDao());
                }
            } else {
                throw new NoAnnotationsExceptions("Didn't found annotations into: "
                        + clazz.getName());
            }
        }
        return instance;
    }
}
