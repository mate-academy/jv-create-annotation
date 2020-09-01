package core.basesyntax.lib;

import core.basesyntax.dao.UniversalDao;
import core.basesyntax.factory.Factory;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoDaoAnnotationInTheClass {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredField = clazz.getDeclaredFields();
        for (Field field : declaredField) {
            if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(UniversalDao.class)) {
                field.setAccessible(true);
                Type type = field.getGenericType();
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    if (Bet.class == parameterizedType.getActualTypeArguments()[0]) {
                        field.set(instance, Factory.getBetDao());
                    }
                    if (User.class == parameterizedType.getActualTypeArguments()[0]) {
                        field.set(instance, Factory.getUserDao());
                    }
                }
            }
        }
        return instance;
    }
}
