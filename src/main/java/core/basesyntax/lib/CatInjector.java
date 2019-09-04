package core.basesyntax.lib;

import core.basesyntax.controller.CatHandler;
import core.basesyntax.dao.CatDaoImpl;
import core.basesyntax.factory.CatDaoFactory;

import java.lang.reflect.Field;

public class CatInjector {
    public static void injectDependency() throws IllegalAccessException {
        Class<CatHandler> catHandlerClass = CatHandler.class;
        Field[] catHandlerFields = catHandlerClass.getDeclaredFields();

        Class<CatDaoImpl> catDaoClass = CatDaoImpl.class;
        if (catDaoClass.getDeclaredAnnotation(Dao.class) == null) {
            throw new IllegalAccessException();
        }
        for (Field field : catHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) == null) {
                throw new IllegalAccessException();
            }
            field.setAccessible(true);
            field.set(null, CatDaoFactory.getCatDao());
        }
    }
}
