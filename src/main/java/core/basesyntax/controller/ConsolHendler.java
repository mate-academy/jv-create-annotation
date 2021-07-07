package core.basesyntax.controller;

import core.basesyntax.dao.BarvinokDao;
import core.basesyntax.dao.VeselkaDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.RequestBarvinok;
import core.basesyntax.model.RequestVeselka;

import java.util.Scanner;

public class ConsolHendler {
    @Inject
    public static VeselkaDao veselkaDao;

    @Inject
    public static BarvinokDao barvinokDao;

    public static void setToVeselkaLine() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("0")) {
                return;
            }
            try {
                String[] data = command.split(" ");
                String name = data[0];
                int id = Integer.parseInt(data[1]);
                RequestVeselka requestVeselka = new RequestVeselka(name, id);
                veselkaDao.makeVeselkaRequest(requestVeselka);
            } catch (Exception e) {
                System.out.println("Помилка введення, повторіть спробу");
            }
        }
    }

    public static void setToBarvinokLine() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("0")) {
                return;
            }
            try {
                String[] data = command.split(" ");
                String name = data[0];
                int id = Integer.parseInt(data[1]);
                RequestBarvinok requestBarvinok = new RequestBarvinok(name, id);
                barvinokDao.makeBarvinokRequest(requestBarvinok);
            } catch (Exception e) {
                System.out.println("Помилка введення, повторіть спробу");
            }
        }
    }
}

