package core.basesyntax;

import core.basesyntax.controller.ConsolHendler;
import core.basesyntax.dao.BarvinokDao;
import core.basesyntax.dao.BarvinokDaoImpl;
import core.basesyntax.dao.VeselkaDao;
import core.basesyntax.dao.VeselkaDaoImpl;
import core.basesyntax.lib.Injector;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Посмотреть видео и создать АНАЛОГИЧНЫЙ проект.
 * <p>
 * Добавить ещё одну модель и DAO слой для неё.
 * Сделать так чтобы поля этой модели ТОЖЕ внедрялись инжектором.
 * Добавить проверки на то, что указан класс, экземпляр которого надо внедрять.
 * Не нужно создавать дополнительную аннотацию по типу инжектора!
 * У вас должно быть всего две аннотации - Dao и Inject.
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
        System.out.println("Це програма для постановки дитини в чергу "
                + "в дитячий садок на навчальний рік "
                + (LocalDate.now().getYear() + 1) + " - " + (LocalDate.now().getYear() + 2) + "\n"
                + "Для запису в садок \"Веселка\"  введіть 1,"
                + " для запису в сдок \"Барвінок\" введіть 2 \n"
                + "Інструкція:\nдля постановки дитини в"
                + " чергу введіть її ім'я і номер свідотцтва про народження через пробіл,"
                + "\nякщо хочете поставити в чергу кілька дітей ,"
                + "вводьте дані дітей через \"ENTER\". \n"
                + "Для отримання інформації про загальну чергу, і виходу, введіть \"0\".");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if (choice.equals("1")) {
            ConsolHendler.setToVeselkaLine();
            VeselkaDao veselkaDao = new VeselkaDaoImpl();
            System.out.println(veselkaDao.getAllList());
        } else if (choice.equals("2")) {
            ConsolHendler.setToBarvinokLine();
            BarvinokDao barvinokDao = new BarvinokDaoImpl();
            System.out.println(barvinokDao.getAllList());
        } else if (choice.equals("0")) {
            System.exit(0);
        }
    }
}
