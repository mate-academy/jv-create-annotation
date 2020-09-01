//package core.basesyntax.lib;
//
//import core.basesyntax.dao.BetDaoImpl;
//import core.basesyntax.factory.Factory;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
//import java.util.Objects;
//
//public class Injector {
//    public static Objects getInstance(Class clazz) throws NoSuchMethodException,
//            IllegalAccessException, InvocationTargetException, InstantiationException {
//        Constructor constructor = clazz.getDeclaredConstructor();
//        Object instance = constructor.newInstance();
//        Field[] declaredFields = clazz.getDeclaredFields();
//        for (Field field : declaredFields) {
//            if (field.getAnnotation(Inject.class) != null) {
//                field.setAccessible(true);
//                field.set(instance, Factory.getBetDao());
//            }
//            if (field.getAnnotation(Dao.class) != null) {
//                field.setAccessible(true);
//                field.set(instance, Factory.getUserDao());
//            }
//        }
//        return instance;
//    }
//}
