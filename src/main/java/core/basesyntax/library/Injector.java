package core.basesyntax.library;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImplementation;
import core.basesyntax.dao.BetUserDao;
import core.basesyntax.dao.BetUserDaoImplementation;
import factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class claz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, DaoException {
        Constructor constructor = claz.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Field[] declaredFieldz = claz.getDeclaredFields();
        for (Field field : declaredFieldz) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)
                        && DaoChecker.checkDaoAnnotationExist(BetDaoImplementation.class)) {
                    field.set(instance, Factory.getBetDao());
                }
                if (field.getType().equals(BetUserDao.class)
                        && DaoChecker.checkDaoAnnotationExist(BetUserDaoImplementation.class)) {
                    field.set(instance, Factory.getBetUserDao());
                }
            }
        }
        return instance;
    }
}
