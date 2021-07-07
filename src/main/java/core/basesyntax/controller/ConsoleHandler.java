package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Human;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    BetDao betDao;

    @Inject
    HumanDao humanDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            Human human = null;
            try {
                String[] betData = command.split(" ");
                String name = betData[0];
                int age = Integer.parseInt(betData[1]);
                int value = Integer.parseInt(betData[2]);
                double risk = Double.parseDouble(betData[3]);
                bet = new Bet(value, risk);
                human = new Human(name, age);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Please, put correct data!");
            }

            humanDao.add(human);
            betDao.add(bet);

            System.out.println(bet == null ? null : bet.toString());
            System.out.println(human == null ? null : human.toString());
        }
    }
}
