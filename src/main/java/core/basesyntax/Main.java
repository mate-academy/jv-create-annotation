package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.CustomerDao;
import core.basesyntax.dao.CustomerDaoImpl;
import core.basesyntax.lib.Injector;

public class Main {
    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Напишите сюда ставку и риск, имя и id через пробел");
        ConsoleHandler.handle();
        BetDao libraryDao = new BetDaoImpl();
        System.out.println(libraryDao.getAll());
        CustomerDao customersDao = new CustomerDaoImpl();
        System.out.println(customersDao.getAll());

    }
}
