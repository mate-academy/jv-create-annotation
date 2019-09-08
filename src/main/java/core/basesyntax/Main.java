package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.GamblerDaoImpl;
import core.basesyntax.lib.Injector;

public class Main {
    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Если хотите сделать ставку, \n"
                + "введите через пробел сумму, риск и ваш электронный адрес.");
        ConsoleHandler.handle();
        System.out.println(new BetDaoImpl().getAll());
        System.out.println(new GamblerDaoImpl().getAll());
    }
}
