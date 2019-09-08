package core.basesyntax.lib;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.GamblerDaoImpl;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.GamblerDaoFactory;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoImplClass = BetDaoImpl.class;
        Class<GamblerDaoImpl> gamblerDaoClass = GamblerDaoImpl.class;
        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                for (Class betDaoInterface : betDaoImplClass.getInterfaces()) {
                    if (betDaoInterface.equals(field.getType())) {
                        if (betDaoImplClass.isAnnotationPresent(Dao.class)) {
                            field.set(null, BetDaoFactory.getBetDao());
                            break;
                        }
                    }
                }
                for (Class gamblerDaoInterface : gamblerDaoClass.getInterfaces()) {
                    if (gamblerDaoInterface.equals(field.getType())) {
                        if (gamblerDaoClass.isAnnotationPresent(Dao.class)) {
                            field.set(null, GamblerDaoFactory.getGamblerDao());
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Ошибка");
        System.exit(0);
    }
}