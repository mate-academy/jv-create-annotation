package lib;

import controller.ConsoleHandler;
import dao.BetDao;
import dao.BetDaoImpl;
import dao.PersonDao;
import dao.PersonDaoImpl;
import factory.BetDaoFactory;
import factory.PersonDaoFactory;

import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException {

        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null
                    && BetDaoImpl.class.getDeclaredAnnotation(Dao.class) != null
                    && field.getType().equals(BetDao.class)) {
                field.setAccessible(true);
                field.set(null, BetDaoFactory.getBetDao());
            }

            if (field.getDeclaredAnnotation(Inject.class) != null
                    && PersonDaoImpl.class.getDeclaredAnnotation(Dao.class) != null
                    && field.getType().equals(PersonDao.class)) {
                field.setAccessible(true);
                field.set(null, PersonDaoFactory.getPersonDao());
            }
        }

    }
}
