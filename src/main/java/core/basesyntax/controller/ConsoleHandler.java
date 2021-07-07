package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.library.Inject;
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
            System.out.println("Enter value and risk for your bet. For quit entry q");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Please, enter valid data");
            }
            betDao.add(bet);
            System.out.println(bet);

            System.out.println("Enter name and age your person");
            String personCommand = scanner.nextLine();
            Person person = null;
            try {
                String[] betData = personCommand.split(" ");
                String name = betData[0];
                int age = Integer.parseInt(betData[1]);
                person = new Person(name, age);
            } catch (NumberFormatException e) {
                System.out.println("Please, enter valid data");
            }
            personDao.add(person);
            System.out.println(person);
        }
    }
}
