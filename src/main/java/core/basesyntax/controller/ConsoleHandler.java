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

            Bet bet = null;
            Person person = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                String name = betData[2];
                int age = Integer.parseInt(betData[3]);
                bet = new Bet(value, risk);
                person = new Person(name, age);
            } catch (NumberFormatException e) {
                System.out.println("Please input correct data");
            }

            betDao.add(bet);
            personDao.add(person);
            System.out.println(bet == null ? null : bet.toString());
            System.out.println(person == null ? null : person.toString());
        }
    }
}
