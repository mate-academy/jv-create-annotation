package core.basesyntax;

import core.basesyntax.controller.App;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.dao.HumanHumanDaoImpl;
import core.basesyntax.library.Injector;

public class Main {

    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        App.something();

        HumanDao humanDao = new HumanHumanDaoImpl();
        System.out.println(humanDao.getAll());
    }
}
