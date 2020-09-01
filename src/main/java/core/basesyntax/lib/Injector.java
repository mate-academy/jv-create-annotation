package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.OrderDao;
import core.basesyntax.dao.OrderDaoImpl;
import core.basesyntax.exception.MyException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException, MyException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();

        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;
        Class<OrderDaoImpl> orderDaoClass = OrderDaoImpl.class;

        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(BetDao.class)) {
                field.setAccessible(true);
                if (betDaoClass.isAnnotationPresent(Dao.class)) {
                    field.set(instance, Factory.getBetDao());
                } else {
                    throw new MyException("Do not found DAO Annotation");
                }
            } else if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(OrderDao.class)) {
                field.setAccessible(true);
                if (orderDaoClass.isAnnotationPresent(Dao.class)) {
                    field.set(instance, Factory.getOrderDao());
                } else {
                    throw new MyException("Do not found DAO Annotation");
                }
            }
        }
        return instance;
    }
}
