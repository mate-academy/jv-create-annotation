package core.basesyntax.lib;

import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDaoImpl;
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
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                Type type = field.getGenericType();
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    if (checkBet(parameterizedType)) {
                        field.set(instance, new BetDaoImpl());
                    }
                    if (checkUser(parameterizedType)) {
                        field.set(instance, new UserDaoImpl());
                    }
                }
            }
        }
        return instance;
    }

    private static boolean checkBet(ParameterizedType parameterizedType)
            throws NoDaoAnnotationInTheClass {
        if (!BetDaoImpl.class.isAnnotationPresent(Dao.class)) {
            throw new NoDaoAnnotationInTheClass("Class " + BetDaoImpl.class
                    + " doesn't contains @Dao annotation!!");
        }
        return Bet.class == parameterizedType.getActualTypeArguments()[0];
    }

    private static boolean checkUser(ParameterizedType parameterizedType)
            throws NoDaoAnnotationInTheClass {
        if (!UserDaoImpl.class.isAnnotationPresent(Dao.class)) {
            throw new NoDaoAnnotationInTheClass("Class " + UserDaoImpl.class
                    + " doesn't contains @Dao annotation!!");
        }
        return User.class == parameterizedType.getActualTypeArguments()[0];
    }
}
