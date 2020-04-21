package core.basesyntax.lib;

import core.basesyntax.controller.IncorrectImpAnnotation;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType() == PersonDao.class && Factory
                        .getPersonDao().getClass().getAnnotation(Dao.class) != null) {
                    field.set(instance, Factory.getPersonDao());
                } else if (field.getType() == BetDao.class && Factory
                        .getBetDao().getClass().getAnnotation(Dao.class) != null) {
                    field.set(instance, Factory.getBetDao());
                } else {
                    throw new IncorrectImpAnnotation("No implement all annotations");
                }
            }
        }
        return instance;
    }
}
