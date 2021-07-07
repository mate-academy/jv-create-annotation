package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.exeptions.NoImplementationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoImplementationException {
        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        Object newInstance = declaredConstructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                if (field.getType().equals(BetDao.class)
                        && Factory.getBetDao().getClass().isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(newInstance, Factory.getBetDao());
                } else if (field.getType().equals(UserDao.class)
                        && Factory.getUserDao().getClass().isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(newInstance, Factory.getUserDao());
                } else {
                    throw new NoImplementationException(field.getName()
                                    + "Відсутня антотація @Dao у класі.");
                }
            }
        }
        return newInstance;
    }
}
