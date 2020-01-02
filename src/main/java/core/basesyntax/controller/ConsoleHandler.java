package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PersonDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Person;

import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private static BetDao betDao;
    @Inject
    private static PersonDao personDao;

    public static void handle() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("0")) {
                return;
            }
            try {
                String[] data = input.split(" ");
                int value = Integer.parseInt(data[0]);
                double risk = Double.parseDouble(data[1]);

                betDao.add(new Bet(value, risk));

                System.out.println("Input name of the person: ");

                String name = scanner.nextLine();
                personDao.add(new Person(name));

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Wrong input");
            }
        }
    }
}
