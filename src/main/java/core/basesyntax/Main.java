package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.library.Injector;

public class Main {
    static {
        try {
            Injector.injectDependecy();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello!\nPlease enter your user"
                + ":(id 'x' /space/ name 'xxxxxx');"
                + "\nEnter '0' to finish;");
        ConsoleHandler.handle();
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.getAll());
    }
}
