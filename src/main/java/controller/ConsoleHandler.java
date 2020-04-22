package controller;

import core.basesyntax.model.Bet;
import core.basesyntax.model.Person;
import dao.BetDao;
import dao.PersonDao;
import database.Storage;
import java.util.Scanner;
import lib.Inject;

public class ConsoleHandler {
    @Inject
    BetDao betDao;
    @Inject
    PersonDao personDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            Person person = null;
            try {
                String[] betData = command.split(" ");
                String name = betData[0];
                int age = Integer.parseInt(betData[1]);
                int value = Integer.parseInt(betData[2]);
                double risk = Double.parseDouble(betData[3]);
                person = new Person(name, age);
                bet = new Bet(value, risk);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Please enter correct data.");
            }
            if (person != null) {
                Storage.persons.add(person);
                System.out.println(person);
            }
            if (bet != null) {
                Storage.bets.add(bet);
                System.out.println(bet);
            }
        }
    }
}
