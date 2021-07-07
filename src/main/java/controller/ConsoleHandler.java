package controller;

import core.basesyntax.model.Bet;
import core.basesyntax.model.Person;
import dao.BetDao;
import dao.PersonDao;
import java.util.Scanner;
import lib.Inject;

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
            String personStr = scanner.nextLine();
            Bet bet = null;
            Person person = null;
            try {
                String[] betData = command.split(" ");
                String[] perData = personStr.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                String name = perData[0];
                int age = Integer.parseInt(perData[1]);
                double luck = Double.parseDouble(perData[2]);
                bet = new Bet(value, risk);
                person = new Person(name, age, luck);
            } catch (NumberFormatException e) {
                System.out.println("Your input is incorrect");
            }
            betDao.add(bet);
            System.out.println(person == null ? null : person.toString());
            personDao.add(person);
            System.out.println(bet == null ? null : bet.toString());
        }
    }
}
