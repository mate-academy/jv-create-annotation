package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.ClientDao;
import core.basesyntax.dao.CreditDao;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, ClassNotFoundException {
        ConsoleHandler consoleHandler = (ConsoleHandler) Injector
                .getInstance(ConsoleHandler.class);
        System.out.println("Enter full name, debt, loan and interest rate:");
        consoleHandler.handle();

        CreditDao creditGenDao = Factory.getCreditDao();
        ClientDao clientGenDao = Factory.getClientDao();
        System.out.println("All credits: " + creditGenDao.getAll());
        System.out.println("All clients: " + clientGenDao.getAll());
    }
}
