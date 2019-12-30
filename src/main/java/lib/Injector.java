package lib;

import controllers.ConsoleHandler;
import dao.BetDao;
import dao.BetDaoImpl;
import dao.CustomerDaoImpl;
import factories.BetDaoFactory;
import factories.CustomerDaoFactory;

import java.lang.reflect.Field;

public class Injector {

    public static void  injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoImplClass = BetDaoImpl.class;
        Class<CustomerDaoImpl> customerDaoImplClass = CustomerDaoImpl.class;
        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                if (betDaoImplClass.getDeclaredAnnotation(Dao.class) != null
                        || customerDaoImplClass.getDeclaredAnnotation(Dao.class) != null) {
                    field.setAccessible(true);
                    if (field.getType() == BetDao.class) {
                        field.set(null, BetDaoFactory.getBetDao());
                    } else {
                        field.set(null, CustomerDaoFactory.getCustomerDao());
                    }
                }
            }
        }
    }
}
