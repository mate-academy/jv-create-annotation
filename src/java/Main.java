import controller.ConsoleHandler;
import exeptions.DaoExistExeption;
import lib.Injector;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException, DaoExistExeption {
        ConsoleHandler handler = (ConsoleHandler) Injector.getInstance(ConsoleHandler.class);
        System.out.println("Введіть дані людини та ставки в форматі: value risk name age");
        handler.handle();
    }
}
