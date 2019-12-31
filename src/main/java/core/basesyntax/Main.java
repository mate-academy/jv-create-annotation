package core.basesyntax;

import core.basesyntax.controllers.ConsoleHandler;
import core.basesyntax.exceptions.AnotationNoExistException;
import core.basesyntax.factory.BetDaoFactory;
import core.basesyntax.factory.HumanDaoFactory;
import core.basesyntax.lib.Injector;

public class Main {
    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException | AnotationNoExistException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Введіть ім'я, прізвище, суму і ризик через пробіл.\n"
                + "Для виходу введіть \"0\"");
        ConsoleHandler.handle();
        System.out.println(BetDaoFactory.getBetDao().getAll());
        System.out.println(HumanDaoFactory.getHumanDao().getAll());
    }
}
