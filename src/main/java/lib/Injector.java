package lib;

import dao.BetDaoImpl;
import dao.UserDaoImpl;
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
                String fieldName = field.getName().toLowerCase();
                if (fieldName.contains("bet")
                        && BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
                    field.set(instance, Factory.getBetDao());
                } else if (fieldName.contains("user")
                        && UserDaoImpl.class.isAnnotationPresent(Dao.class)) {
                    field.set(instance, Factory.getUserDao());
                } else {
                    throw new NoDaoAnnotationFound("No Dao Annotation Found");
                }
            }
        }
        return instance;
    }
}
