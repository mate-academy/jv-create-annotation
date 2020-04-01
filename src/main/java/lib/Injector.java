package lib;

import controller.ConsoleHandler;
import dao.BetDaoImpl;
import dao.HumanDaoImpl;
import factory.BetDaoFactory;
import factory.HumanDaoFactory;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoImplClass = BetDaoImpl.class;
        Class<HumanDaoImpl> humanDaoImplClass = HumanDaoImpl.class;

        Field[] consolHandlersFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consolHandlersFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && betDaoImplClass.getAnnotation(Dao.class) != null
                    && field.getType() == BetDaoImpl.class) {
                field.setAccessible(true);
                field.set(null, BetDaoFactory.getBetDao());
            }
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && humanDaoImplClass.getAnnotation(Dao.class) != null
                    && field.getType() == HumanDaoImpl.class) {
                field.setAccessible(true);
                field.set(null, HumanDaoFactory.getHumanDao());
            }
        }
    }
}
