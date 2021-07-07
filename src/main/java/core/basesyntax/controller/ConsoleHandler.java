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
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Person person = null;
            Bet bet = null;
            try {
                String[] info = command.split(" ");
                String name = info[0];
                int age = Integer.parseInt(info[1]);
                int value = Integer.parseInt(info[2]);
                double risk = Double.parseDouble(info[3]);
                person = new Person(name, age);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Please enter correct data");
            }
            personDao.addPerson(person);
            System.out.println(person == null ? null : person.toString());

            betDao.add(bet);
            System.out.println(bet == null ? null : bet.toString());

        }
    }
}
