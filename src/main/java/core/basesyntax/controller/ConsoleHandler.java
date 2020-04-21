package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Human;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private BetDao betDao;
    @Inject
    private HumanDao humanDao;

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
                int age = Integer.parseInt(betData[0]);
                String name = betData[1];
                int value = Integer.parseInt(betData[2]);
                double risk = Double.parseDouble(betData[3]);
                human = new Human(name, age);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Wrong data");
            }
            humanDao.add(human);
            System.out.println(human == null ? null : human.toString());
            betDao.add(bet);
            System.out.println(bet == null ? null : bet.toString());
        }
    }
}
