package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Person;

import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private static BetDao betDao;

    @Inject
    private static PersonDao personDao;

    public static void handle() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String command = scanner.nextLine();
                if (command.equals("0")) {
                    return;
                }
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[0]);
                double risk = Double.parseDouble(data[1]);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
            }
        } catch (Exception e) {
            System.out.println("Дані введені некоректно");
        }

    }

    public static void handlePerson() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String line = scanner.nextLine();
                if (line.equals("exit")) {
                    return;
                }
                String[] dataPerson = line.split(" ");
                String name = dataPerson[0];
                int age = Integer.parseInt(dataPerson[1]);
                Person person = new Person(name, age);
                personDao.add(person);
            }
        } catch (Exception e) {
            System.out.println("Дані введені некоректно");
        }
    }

    public static BetDao getBetDao() {
        return betDao;
    }

    public static PersonDao getPersonDao() {
        return personDao;
    }
}
