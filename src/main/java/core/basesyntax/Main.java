package core.basesyntax;

import controller.ConsoleHandler;
import dao.SmartPhoneDao;
import dao.SmartPhoneDaoImpl;
import dao.TabletDao;
import dao.TabletDaoImpl;
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
        System.out.println("Для добавления смартфона введите smart, модель и цену\n"
                + "через пробел, к примеру: smart Galaxy_S10 999.99\n"
                + "Для добавления планшета введите tablet, модель и цену\n"
                + "через пробел, к примеру: tablet Note_4 1199.99\n"
                + "Для выхода введите 0");
        ConsoleHandler.handle();
        SmartPhoneDao smartPhoneDao = new SmartPhoneDaoImpl();
        System.out.println(smartPhoneDao.getAll());
        TabletDao tabletDao = new TabletDaoImpl();
        System.out.println(tabletDao.getAll());
    }
}
