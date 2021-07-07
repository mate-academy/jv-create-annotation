package core.basesyntax.lib;

import core.basesyntax.controller.ConsolHendler;
import core.basesyntax.dao.BarvinokDao;
import core.basesyntax.dao.BarvinokDaoImpl;
import core.basesyntax.dao.VeselkaDao;
import core.basesyntax.dao.VeselkaDaoImpl;
import core.basesyntax.factory.RequestBarvinokDaoFactory;
import core.basesyntax.factory.RequestVeselkaDaoFactory;

import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException {
        Class<ConsolHendler> consolHendlerClass = ConsolHendler.class;
        Class<VeselkaDaoImpl> requestVeselkaDaoClass = VeselkaDaoImpl.class;
        Class<BarvinokDaoImpl> requestBarvinokDaoClass = BarvinokDaoImpl.class;
        Field[] consolHendlerFields = consolHendlerClass.getDeclaredFields();
        for (Field field : consolHendlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                if (field.getType().equals(VeselkaDao.class)) {
                    if (requestVeselkaDaoClass.getDeclaredAnnotation(Dao.class) != null) {
                        field.setAccessible(true);
                        field.set(null, RequestVeselkaDaoFactory.getRequestVeselkaDao());
                    } else {
                        System.out.println(" Error");
                    }
                }
                if (field.getType().equals(BarvinokDao.class)) {
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
