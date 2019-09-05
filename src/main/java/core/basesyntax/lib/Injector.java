package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.HumanDaoImpl;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.HumanDaoFactory;

import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoImplClass = BetDaoImpl.class;
        Class<HumanDaoImpl> humanDaoImplClass = HumanDaoImpl.class;

        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(BetInject.class) != null
                    && betDaoImplClass.getDeclaredAnnotation(BetDaoAnn.class) != null) {
                field.setAccessible(true);
                field.set(null, BetDaoFactory.getBetDao());
            }
            if (field.getDeclaredAnnotation(HumanInject.class) != null
                    && humanDaoImplClass.getDeclaredAnnotation(HumanDaoAnn.class) != null) {
                field.setAccessible(true);
                field.set(null, HumanDaoFactory.getHumanDao());
            }
        }
    }
}
