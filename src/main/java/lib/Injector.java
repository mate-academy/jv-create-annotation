package lib;

import dao.BetDao;
import dao.BetDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import factory.BetDaoFactory;
import factory.UserDaoFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class<controller.ConsoleHandler> clazz) throws
            NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Constructor<controller.ConsoleHandler> constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;
        Class<UserDaoImpl> userDaoClass = UserDaoImpl.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                if (betDaoClass.getAnnotation(Dao.class) != null
                        && field.getType().equals(BetDao.class)) {
                    field.setAccessible(true);
                    field.set(instance, BetDaoFactory.getBetDao());
                }
                if (userDaoClass.getAnnotation(Dao.class) != null
                        && field.getType().equals(UserDao.class)) {
                    field.setAccessible(true);
                    field.set(instance, UserDaoFactory.getUserDao());
                }
            }
        }
        return instance;
    }
}
