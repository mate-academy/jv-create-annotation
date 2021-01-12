package lib;

import dao.BetDao;
import dao.HorseDao;
import factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clss) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {

        Constructor constructor = clss.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field [] declaredFields = clss.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)
                            && Factory.getBetDao().getClass().isAnnotationPresent(Dao.class)) {
                    field.set(instance, Factory.getBetDao());
                } else
                    if (field.getType().equals(HorseDao.class)
                            && Factory.getHorseDao().getClass().isAnnotationPresent(Dao.class)) {
                        field.set(instance, Factory.getHorseDao());
                    } else {
                        throw new RuntimeException("Annotation's implementation is wrong");
                    }
            }
        }
        return instance;
    }
}
