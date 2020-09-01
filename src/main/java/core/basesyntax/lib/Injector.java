package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clas) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoClassAnnotation {
        Constructor constructor = clas.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clas.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (checkBet(field)) {
                    field.set(instance, Factory.getBetDao());
                    continue;
                }
                if (checkUser(field)) {
                    field.set(instance, Factory.getUserDao());
                }
            }
        }
        return instance;
    }

    private static boolean checkBet(Field field) throws NoClassAnnotation {
        if (BetDaoImpl.class.getAnnotation(Dao.class) == null) {
            throw new NoClassAnnotation("BetDaoImpl class has no @Dao annotation");
        }
        return field.getType().equals(BetDao.class);
    }

    private static boolean checkUser(Field field) throws NoClassAnnotation {
        if (UserDaoImpl.class.getAnnotation(Dao.class) == null) {
            throw new NoClassAnnotation("UserDaoImpl class has no @Dao annotation");
        }
        return field.getType().equals(UserDao.class);
    }
}
