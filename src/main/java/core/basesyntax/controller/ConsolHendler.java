package core.basesyntax.controller;

import core.basesyntax.dao.RequestBarvinokDao;
import core.basesyntax.dao.RequestBarvinokDaoImpl;
import core.basesyntax.dao.RequestVeselkaDao;
import core.basesyntax.dao.RequestVeselkaDaoImpl;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.RequestBarvinok;
import core.basesyntax.model.RequestVeselka;

import java.util.Scanner;

public class ConsolHendler {
    @Inject
    public static RequestVeselkaDao requestVeselkaDao;

    @Inject
    public static RequestBarvinokDao requestBarvinokDao;

    public static void handle1() {
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
                RequestVeselkaDao requestVeselkaDao = new RequestVeselkaDaoImpl();
                requestVeselkaDao.makeRequest(requestVeselka);
            } catch (Exception e) {
                System.out.println("Помилка введення, повторіть спробу");
            }
        }
    }

    public static void handle2() {
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
                RequestBarvinokDao requestBarvinokDao = new RequestBarvinokDaoImpl();
                requestBarvinokDao.makeRequest(requestBarvinok);
            } catch (Exception e) {
                System.out.println("Помилка введення, повторіть спробу");
            }
        }
    }
}
