package controller;

import dao.BetDao;
import dao.PersonDao;
import java.util.Scanner;
import lib.Inject;
import model.Bet;
import model.Person;

public class ConsoleHandler {

    @Inject
    private static BetDao betDao;

    @Inject
    private static PersonDao personDao;

    public static void handle() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {

                String command = scanner.nextLine();
                if (command.equals("0")) {
                    return;
                }

                String[] data = command.split(" ");
                int value = Integer.parseInt(data[0]);
                double risk = Double.parseDouble(data[1]);
                int id = Integer.parseInt(data[2]);
                String name = data[3];
                Bet bet = new Bet(value, risk);
                Person person = new Person(id, name);
                betDao.add(bet);
                personDao.add(person);
            }
        } catch (Exception e) {
            System.out.println("Данные введены некорректно");
        }

    }
}
