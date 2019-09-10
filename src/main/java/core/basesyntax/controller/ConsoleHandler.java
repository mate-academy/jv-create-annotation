package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.models.Bet;
import core.basesyntax.models.Person;

import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private static BetDao betDao;

    @Inject
    private static PersonDao personDao;

    public static void handle() {
        System.out.println("Чтобы добавить ставку, введите \n"
                + "сумму, риск, имя пользователя через пробел");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String command = scanner.nextLine();
                if (command.equals("0")) {
                    return;
                }
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[0]);
                double risk = Double.parseDouble(data[1]);
                String name = data[2];
                Bet bet = new Bet(value, risk);
                Person person = new Person(name);
                betDao.add(bet);
                personDao.add(person);
            }
        } catch (Exception e) {
            System.out.println("Данные введены некорректно");
        }
    }
}
