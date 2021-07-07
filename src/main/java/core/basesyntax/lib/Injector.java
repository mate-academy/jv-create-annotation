package core.basesyntax.lib;

import core.basesyntax.controller.ConsolHendler;
import core.basesyntax.dao.RequestBarvinokDao;
import core.basesyntax.dao.RequestBarvinokDaoImpl;
import core.basesyntax.dao.RequestVeselkaDao;
import core.basesyntax.dao.RequestVeselkaDaoImpl;
import core.basesyntax.factory.RequestBarvinokDaoFactory;
import core.basesyntax.factory.RequestVeselkaDaoFactory;

import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException {
        Class<ConsolHendler> consolHendlerClass = ConsolHendler.class;
        Class<RequestVeselkaDaoImpl> requestVeselkaDaoClass = RequestVeselkaDaoImpl.class;
        Class<RequestBarvinokDaoImpl> requestBarvinokDaoClass = RequestBarvinokDaoImpl.class;
        Field[] consolHendlerFields = consolHendlerClass.getDeclaredFields();
        for (Field field : consolHendlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                if (field.getType().equals(RequestVeselkaDao.class)) {
                    if (requestVeselkaDaoClass.getDeclaredAnnotation(Dao.class) != null) {
                        field.setAccessible(true);
                        field.set(null, RequestVeselkaDaoFactory.getRequestVeselkaDao());
                    } else {
                        System.out.println(" Error");
                    }
                }
                if (field.getType().equals(RequestBarvinokDao.class)) {
                    if (requestBarvinokDaoClass.getDeclaredAnnotation(Dao.class) != null) {
                        field.setAccessible(true);
                        field.set(null, RequestBarvinokDaoFactory.getRequesBarvinokDao());
                    } else {
                        System.out.println(" Error");
                    }
                }
            }
        }
    }
}
