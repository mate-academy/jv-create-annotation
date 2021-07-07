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
                String name = betData[0];
                String surname = betData[1];
                int value = Integer.parseInt(betData[2]);
                double risk = Double.parseDouble(betData[3]);
                bet = new Bet(value, risk);
                person = new Person(name, surname, bet);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Wrong data! Please, try again!");
            }
            if (bet != null && person != null) {
                betDao.add(bet);
                personDao.add(person);
            }
        }
    }
}
