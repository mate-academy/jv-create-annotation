package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetImp;
import core.basesyntax.dao.CustomersDao;
import core.basesyntax.dao.CustomersImp;

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
        BetDao libraryDao = new BetImp();
        System.out.println(libraryDao.getAll());
        CustomersDao customersDao = new CustomersImp();
        System.out.println(customersDao.getAll());

    }
}
