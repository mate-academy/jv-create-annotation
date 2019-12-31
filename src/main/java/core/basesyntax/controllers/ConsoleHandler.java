package core.basesyntax.controllers;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.dao.HumanDaoImpl;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Human;

import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private static BetDao betDao;

    @Inject
    private static HumanDao humanDao;

    public static void handle() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.toLowerCase().equals("stop")) {
                return;
            }
            try {
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[2]);
                double risk = Double.parseDouble(data[3]);
                BetDao betDao = new BetDaoImpl();
                betDao.add(new Bet(value, risk));
                HumanDao humanDao = new HumanDaoImpl();
                humanDao.add(new Human(data[0], data[1]));

            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("data entered incorrectly!!!");
            }
        }
    }
}
