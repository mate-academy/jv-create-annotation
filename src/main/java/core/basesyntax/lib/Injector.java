package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.CustomerDao;
import core.basesyntax.dao.CustomerDaoImpl;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.CustomerDaoFactory;
import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betImplClass = BetDaoImpl.class;
        Class<CustomerDaoImpl> customerImplDaoClass = CustomerDaoImpl.class;

        Field[] consoleHadlersFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHadlersFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && betImplClass.getDeclaredAnnotation(Dao.class) != null
                    && field.getType() == BetDao.class) {
                field.setAccessible(true);
                field.set(null, BetDaoFactory.getLibrary());
            }
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && customerImplDaoClass.getDeclaredAnnotation(Dao.class) != null
                    && field.getType() == CustomerDao.class) {
                field.setAccessible(true);
                field.set(null, CustomerDaoFactory.getLibrary());
            }
        }
    }
}
