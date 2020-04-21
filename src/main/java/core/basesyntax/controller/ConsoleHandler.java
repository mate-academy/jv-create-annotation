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

        System.out.printf("Для завершення заповнення введіть \"q\".\n");
        while (true) {
            System.out.print("Введіть ім'я та фамілію: ");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }

            String[] name = command.split(" ");
            Person person = new Person(name[0], name[1]);
            personDao.add(person);

            Bet bet = null;
            try {
                System.out.print("Введыть розмыр ставки та ризик церез пробіл: ");
                command = scanner.nextLine();
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Будь ласка, введіть коректні дані.");
            }
            betDao.add(bet);
            System.out.println(person == null ? null : person.toString());
            System.out.println(bet == null ? null : bet.toString());
        }
    }
}
