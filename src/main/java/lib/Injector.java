package lib;

import dao.BetDao;
import dao.BetDaoImpl;
import dao.PersonDao;
import dao.PersonDaoImpl;
import exceptions.NoDaoAnnotatedFieldException;
import factory.BetDaoFactory;
import factory.PersonDaoFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class<controller.ConsoleHandler> clazz)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            InstantiationException, NoClassDefFoundError, NoDaoAnnotatedFieldException {
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
                    && field.getType().equals(PersonDao.class)
                    && checkDaoClassSelection(PersonDaoImpl.class)) {
                field.setAccessible(true);
                field.set(instance, PersonDaoFactory.getPersonDao());
            }
        }
        return instance;
    }

    private static boolean checkDaoClassSelection(Class<?> clazz)
            throws NoDaoAnnotatedFieldException {
        if (clazz.getAnnotation(Dao.class) != null) {
            return true;
        }
        throw new NoDaoAnnotatedFieldException("No Dao Class selected!");
    }
}
