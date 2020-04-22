package core.basesyntax.library;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImp;
import core.basesyntax.dao.UserDao;
import core.basesyntax.exceptions.NoDaoAnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoDaoAnnotationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] clazzFields = clazz.getDeclaredFields();
        for (Field field: clazzFields) {
            if (field.getAnnotation(Inject.class) != null) {
                if (field.getType().equals(BetDao.class)
                        && BetDaoImp.class.getAnnotation(Dao.class) != null) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getBetDao());
                } else if (field.getType().equals(UserDao.class)
                        && BetDaoImp.class.getAnnotation(Dao.class) != null) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getUserDao());
                } else {
                    throw new NoDaoAnnotationException("No Dao annotation was found");
                }
            }
        }
        return instance;
    }
}
