package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.dao.UserEmailDao;
import core.basesyntax.dao.UserEmailDaoImpl;
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
        System.out.println("Если хотите создать учетную запись, \n"
                + "введите через пробелы логин, пароль, Ваше имя, Ваш возраст");
        ConsoleHandler.handle();
        UserEmailDao userEmailDao = new UserEmailDaoImpl();
        System.out.println(userEmailDao.getAll());
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.getAll());
    }
}
