package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.impl.BetDaoImpl;
import core.basesyntax.dao.impl.UserDaoImpl;
import core.basesyntax.exception.AnnotationException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        Object instance = declaredConstructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                Object dao = new Object();
                if (field.getType() == BetDao.class) {
                    dao = new BetDaoImpl();
                }
                if (field.getType() == UserDao.class) {
                    dao = new UserDaoImpl();
                }
                if (dao.getClass().getAnnotation(Dao.class) == null) {
                    throw new AnnotationException("Can't find" + Dao.class + "annotation");
                } else {
                    field.set(instance, dao);
                }
            }
        }
        return instance;
    }
}
