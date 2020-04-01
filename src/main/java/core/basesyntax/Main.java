package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.PersonDaoFactory;
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
        System.out.println("Якщо хочете зробити ставку, введіть \n"
                            + "суму і риск через пробіл");
        ConsoleHandler.handle();
        BetDao betDao = BetDaoFactory.getBetDao();
        System.out.println(betDao.getAll());

        System.out.println("Введіть ім'я і вік людини через пробіл");
        ConsoleHandler.handlePerson();
        PersonDao personDao = PersonDaoFactory.getPersonDao();
        System.out.println(personDao.getAll());
    }
}
