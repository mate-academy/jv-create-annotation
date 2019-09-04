package core.basesyntax.controller;

import core.basesyntax.dao.CatDao;
import core.basesyntax.dao.CatDaoImpl;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Cat;

import java.util.Scanner;

public class CatHandler {

    @Inject
    private static CatDao catDao;

    public static void handleCat() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("0")) {
                return;
            }
            try {
                String[] data = command.split(" ");
                int age = Integer.parseInt(data[0]);
                String name = (data[1]);
                Cat cat = new Cat(age, name);
                CatDao betDao = new CatDaoImpl();
                betDao.add(cat);
            } catch (Exception e) {
                System.out.println("Данные введены не корректно");
            }
        }
    }
}
