package core.basesyntax.lib;

import core.basesyntax.factory.DaoFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        Object instance = declaredConstructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        Method[] daoFactoryMethods = DaoFactory.class.getDeclaredMethods();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                for (int i = 0; i < daoFactoryMethods.length; i++) {
                    if (daoFactoryMethods[i].getAnnotation(Dao.class) != null
                            && daoFactoryMethods[i].getReturnType().equals(field.getType())) {
                        daoFactoryMethods[i].setAccessible(true);
                        field.set(instance, daoFactoryMethods[i].invoke(null));
                        break;
                    }
                    if (i == daoFactoryMethods.length - 1) {
                        throw new NoSuchMethodException(String
                                .format("No @Dao method for %s found", field.getName()));
                    }
                }
            }
        }
        return instance;
    }
}
