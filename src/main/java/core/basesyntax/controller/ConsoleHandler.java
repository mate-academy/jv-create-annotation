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
                String name = betData[2];
                int cashBack = Integer.parseInt(betData[3]);
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
                person = new Person(name, cashBack);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Будь ласка, введіь коректні дані");
            }
            betDao.add(bet);
            System.out.println(bet == null ? null : bet.toString());
            personDao.add(person);
            System.out.println(person == null ? null : person.toString());
        }
    }
}
