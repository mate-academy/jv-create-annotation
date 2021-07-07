package lib;

import dao.BetDao;
import dao.UserDao;
import exceptions.NoDaoAnnotationFound;
import factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoDaoAnnotationFound {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)
                        && Factory.getBetDao().getClass().isAnnotationPresent(Dao.class)) {
                    field.set(instance, Factory.getBetDao());
                } else if (field.getType().equals(UserDao.class)
                        && Factory.getUserDao().getClass().isAnnotationPresent(Dao.class)) {
                    field.set(instance, Factory.getUserDao());
                } else {
                    throw new NoDaoAnnotationFound("No implementation found for type "
                            + field.getType());
                }
            }
        }
        return instance;
    }
}
