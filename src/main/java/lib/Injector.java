package lib;

import controller.ConsoleHandler;
import dao.betDaoImpl;
import factory.betDaoFactory;

import java.lang.reflect.Field;

//рефлексия
public class Injector {
    public static void InjectDependency() throws IllegalAccessException {
        //объект класса который описывает класс
        //получаем объект типа класс который описывает класс консол хэндлер
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<betDaoImpl> betDaoClass = betDaoImpl.class;

        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field:consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                field.set(null, betDaoFactory.getBetDao());
            }
        }
    }
}
