package lib;

import controller.ConsoleHandler;
import dao.BetDao;
import dao.BetDaoImpl;
import dao.HumanDao;
import dao.HumanDaoImpl;
import factory.BetDaoFactory;
import factory.HumanDaoFactory;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoImplClass = BetDaoImpl.class;
        Class<HumanDaoImpl> humanDaoImplClass = HumanDaoImpl.class;

        Field[] consoleHandlerfields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerfields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)) {
                    if (betDaoImplClass.getDeclaredAnnotation(Dao.class) != null) {
                        field.set(null, BetDaoFactory.getBetDao());
                    } else {
                        System.out.println("DAO not found");
                    }
                }
                if (field.getType().equals(HumanDao.class)) {
                    if (humanDaoImplClass.getDeclaredAnnotation(Dao.class) != null) {
                        field.set(null, HumanDaoFactory.getHumanDao());
                    } else {
                        System.out.println("DAO not found");
                    }
                }
            }
        }
    }
}
