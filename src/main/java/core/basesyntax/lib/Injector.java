package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.exceptions.AnnotationDaoIsNotExist;
import core.basesyntax.factory.BetFactory;
import core.basesyntax.factory.PersonFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, ClassNotFoundException, AnnotationDaoIsNotExist {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                Class newClazz = null;
                Object newInstance = null;
                if (field.getType() == BetDao.class) {
                    newClazz = Class.forName("core.basesyntax.dao.BetDaoImpl");
                    newInstance = BetFactory.getBetDao();

                }
                if (field.getType() == PersonDao.class) {
                    newClazz = Class.forName("core.basesyntax.dao.PersonDaoImpl");
                    newInstance = PersonFactory.getPersonDao();
                }
                Constructor newClazzConstructor = newClazz.getDeclaredConstructor();
                field.setAccessible(true);
                if (!newClazz.isAnnotationPresent(Dao.class)) {
                    throw new AnnotationDaoIsNotExist("Dao annotation does not exist. TypeField: "
                            + field.getType() + "FieldName: " + field.getName());
                }
                field.set(instance, newInstance);
            }
        }
        return instance;
    }
}
