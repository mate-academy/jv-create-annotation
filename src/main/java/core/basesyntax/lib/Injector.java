package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.impl.BetDaoImpl;
import core.basesyntax.dao.impl.UserDaoImpl;
import core.basesyntax.exceptions.NoAnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoAnnotationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Class fieldType = field.getType();
                if (fieldType.equals(BetDao.class)
                        && BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
                    field.set(instance, Factory.getBetDao());
                } else if (fieldType.equals(UserDao.class)
                        && UserDaoImpl.class.isAnnotationPresent(Dao.class)) {
                    field.set(instance, Factory.getUserDao());
                } else {
                    throw new NoAnnotationException("Please annotate your class "
                            + fieldType.getName());
                }
            } else {
                throw new NoAnnotationException("Please annotate your field " + field.getName());
            }
        }
        return instance;
    }
}
