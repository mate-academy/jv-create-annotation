package core.basesyntax;

import controller.ConsoleHandler;
import dao.BetDao;
import dao.BetDaoImpl;
import dao.PersonDao;
import dao.PersonDaoImpl;
import lib.Injector;

public class Main {

    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println("Сделайте Вашу ставку: \n"
                + " Введите через пробел сумму и риск,  \n"
                + " а также номер пользователя и имя");

        ConsoleHandler.handle();

        BetDao betDao = new BetDaoImpl();
        PersonDao personDao = new PersonDaoImpl();

        System.out.println(betDao.getAll() + " " + personDao.getAll());

    }
}
