package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Person;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    BetDao betDao;
    @Inject
    PersonDao personDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите имя и возраст через пробел");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            Person person = null;
            try {
                String[] personInfo = command.split(" ");
                String name = personInfo[0];
                int age = Integer.parseInt(personInfo[1]);
                person = new Person(name, age);

                System.out.println("Введите ставку и риск через пробел");
                command = scanner.nextLine();
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите коректные данные");
            }
            personDao.add(person);
            betDao.add(bet);
            System.out.println(person == null ? null : person.toString());
            System.out.println(bet == null ? null : bet.toString());
        }

    }
}
