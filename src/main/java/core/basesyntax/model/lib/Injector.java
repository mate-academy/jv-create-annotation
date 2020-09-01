package core.basesyntax.model.lib;

import core.basesyntax.model.dao.BetDao;
import core.basesyntax.model.dao.UserDao;
import core.basesyntax.model.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoDaoAnnotationException {

        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            field.setAccessible(true);
            if (field.getAnnotation(Inject.class) != null) {
                if (checkBetDaoType(field)) {
                    field.set(instance, Factory.getBetDao());
                }
                if (checkUserDaoType(field)) {
                    field.set(instance, Factory.getUserDao());
                }
            }
        }
        return instance;
    }

    private static boolean checkBetDaoType(Field field) {
        if (!BetDao.class.isAnnotationPresent(Dao.class)) {
            throw new NoDaoAnnotationException(BetDao.class + " does't contain @Dao annotation");
        }
        return field.getType().equals(BetDao.class);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    private static boolean checkUserDaoType(Field field) {
        if (!UserDao.class.isAnnotationPresent(Dao.class)) {
            throw new NoDaoAnnotationException(UserDao.class + " does't contain @Dao annotation");
        }
        return field.getType().equals(UserDao.class);
    }
}
