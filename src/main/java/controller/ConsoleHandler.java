package controller;

import dao.SmartPhoneDao;
import dao.TabletDao;
import java.util.Scanner;
import lib.Inject;
import model.SmartPhone;
import model.Tablet;

public class ConsoleHandler {

    @Inject
    private static SmartPhoneDao smartPhoneDao;

    @Inject
    private static TabletDao tabletDao;

    public static void handle() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String command = scanner.nextLine();
                if (command.equals("0")) {
                    return;
                }
                String[] data = command.split(" ");
                switch (data[0]) {
                    case "smart":
                        String smartModel = data[1];
                        float smartPrice = Float.parseFloat(data[2]);
                        SmartPhone smartPhone = new SmartPhone(smartModel, smartPrice);
                        smartPhoneDao.add(smartPhone);
                        break;
                    case "tablet":
                        String tabletModel = data[1];
                        float tabletPrice = Float.parseFloat(data[2]);
                        Tablet tablet = new Tablet(tabletModel, tabletPrice);
                        tabletDao.add(tablet);
                        break;
                    default:
                        System.out.println("Данные введены некорректно");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Данные введены некорректно");
        }
    }
}
