package lib;

import factory.BetDaoFactory;
import factory.PersonDaoFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class<controller.ConsoleHandler> clazz)
            throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoClassDefFoundError {
        Constructor<controller.ConsoleHandler> constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(BetDao.class)) {
                field.setAccessible(true);
                field.set(instance, BetDaoFactory.getBetDao());
            }
            if (field.getAnnotation(Inject.class) != null
                    && field.getType().getSimpleName().equalsIgnoreCase("PersonDao")) {
                field.setAccessible(true);
                field.set(instance, PersonDaoFactory.getPersonDao());
            }
        }
        return instance;
    }
}
