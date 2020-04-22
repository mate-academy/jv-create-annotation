package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Person;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private BetDao betDao;
    @Inject
    private PersonDao personDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Person person = null;
            Bet bet = null;
            System.out.println("Введіть ваші ім'я, фамілію, value та risk вашої ставки");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                return;
            }
            String[] data = input.split(" ");
            try {
                String name = data[0];
                String surname = data[1];
                int value = Integer.parseInt(data[2]);
                double risk = Double.parseDouble(data[3]);
                person = new Person(name, surname);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Будь ласка введіть коректні дані");
            }
            if (person != null && bet != null) {
                personDao.add(person);
                betDao.add(bet);
                System.out.println(person.toString());
                System.out.println(bet.toString());
            }
        }
    }
}
