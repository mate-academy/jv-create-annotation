package core.basesyntax;

import core.basesyntax.controller.CatHandler;
import core.basesyntax.dao.CatDao;
import core.basesyntax.dao.CatDaoImpl;
import core.basesyntax.lib.Injector;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Если добавить котика, введите \n" 
                           + "возраст котика и кго имя через пробел");
        CatHandler.handleCat();
        CatDao catDao = new CatDaoImpl();
        System.out.println(catDao.getAll());
    }

}
