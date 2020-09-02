package core.basesyntax.service;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.exceptions.NoAnnotationPresentException;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Dao;
import core.basesyntax.lib.Inject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static final String EXC_MESSAGE = "Annotation @Dao is absent in ";

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Field[] declaredFields = clazz.getDeclaredFields();
        Object instance = clazz.getDeclaredConstructor().newInstance();
        isDaoAnnotationExist();

        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)) {
                    field.set(instance, Factory.getBetDao());
                }
                if (field.getType().equals(UserDao.class)) {
                    field.set(instance, Factory.getUserDao());
                }
            }
        }
        return instance;
    }

    private static void isDaoAnnotationExist() {
        if (!UserDaoImpl.class.isAnnotationPresent(Dao.class)) {
            throw new NoAnnotationPresentException(EXC_MESSAGE, UserDaoImpl.class);
        }
        if (!BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
            throw new NoAnnotationPresentException(EXC_MESSAGE, BetDaoImpl.class);
        }
    }
}
