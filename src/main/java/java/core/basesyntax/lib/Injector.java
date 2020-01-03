package java.core.basesyntax.lib;

import java.core.basesyntax.controller.ConsoleHandler;
import java.core.basesyntax.dao.BetDao;
import java.core.basesyntax.dao.BetDaoImpl;
import java.core.basesyntax.dao.ClientDao;
import java.core.basesyntax.dao.ClientDaoImpl;
import java.core.basesyntax.exception.AnnotationNotFoundException;
import java.core.basesyntax.factory.BetDaoFactory;
import java.core.basesyntax.factory.ClientDaoFactory;

import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoImplClass = BetDaoImpl.class;
        Class<ClientDaoImpl> clientDaoImplClass = ClientDaoImpl.class;

        Field[] consoleHandlersFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlersFields) {
            if (field.getAnnotation(Inject.class) != null && field.getType().equals(BetDao.class)) {
                if (betDaoImplClass.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(null, BetDaoFactory.getBetDao());
                } else {
                    throw new AnnotationNotFoundException();
                }
            }
            if (field.getAnnotation(Inject.class) != null
                    && field.getType().equals(ClientDao.class)) {
                if (clientDaoImplClass.isAnnotationPresent(Dao.class)) {
                    field.setAccessible(true);
                    field.set(null, ClientDaoFactory.getClientDao());
                } else {
                    throw new AnnotationNotFoundException();
                }
            }
        }
    }
}
