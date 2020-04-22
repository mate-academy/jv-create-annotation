package lib;

import dao.BetDaoImpl;
import dao.PersonDaoImpl;
import exception.AnnotationNotFoundException;
import factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstanse(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException,
            AnnotationNotFoundException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;
        Class<PersonDaoImpl> personDaoClass = PersonDaoImpl.class;
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                if (field.getName().equals("betDao")
                        && betDaoClass.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getBetDao());
                } else if (field.getName().equals("personDao")
                        && personDaoClass.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getPersonDao());
                } else {
                    throw new AnnotationNotFoundException("Annotation is not present");
                }
            }
        }
        return instance;
    }
}
