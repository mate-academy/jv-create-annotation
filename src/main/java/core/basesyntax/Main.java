package core.basesyntax;

import core.basesyntax.dao.AnimalDao;
import core.basesyntax.dao.AnimalDaoImpl;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.handlers.ConsoleHandler;
import core.basesyntax.lib.Injector;

import java.util.Scanner;

public class Main {

    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Если хотите сделать ставку, введите \n"
                    + "сумму, риск и свое имя через пробел");
            ConsoleHandler.handle(BetDao.class.getName(), scanner);
            BetDao betDao = new BetDaoImpl();
            System.out.println("Если хотите добавить животное, введите \n"
                    + "его имя и количество healthpoints");
            ConsoleHandler.handle(AnimalDao.class.getName(), scanner);
            AnimalDao animalDao = new AnimalDaoImpl();
            System.out.println(betDao.getAll() + "\n" + animalDao.getAll());
        }
    }
}