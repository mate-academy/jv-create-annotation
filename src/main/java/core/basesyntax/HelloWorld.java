package core.basesyntax;

import java.util.Collections;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        System.out.println("Напишите сюда свою колекцию, имя и id через пробел");
        ConsoleHandler.handle();
        LibraryDao libraryDao = new LibraryImp();
        System.out.println(libraryDao.getAll());
        CustomersDao customersDao = new CustomersImp();
        System.out.println(customersDao.getAll());

    }
}
