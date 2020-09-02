package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.OrderDao;
import core.basesyntax.dao.OrderDaoImpl;
import core.basesyntax.exception.DaoIsNotFindException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, DaoIsNotFindException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();

        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;
        Class<OrderDaoImpl> orderDaoClass = OrderDaoImpl.class;

        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                if (field.getType().equals(BetDao.class)
                        && betDaoClass.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(instance, Factory.getBetDao());
                }
            } else if (field.getType().equals(OrderDao.class)
                    && orderDaoClass.isAnnotationPresent(Dao.class)) {
                field.setAccessible(true);
                field.set(instance, Factory.getOrderDao());
            } else {
                throw new DaoIsNotFindException("Do not found DAO Annotation");
            }
        }
        return instance;
    }
}
