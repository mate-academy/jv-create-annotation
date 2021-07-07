package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.models.Bet;
import core.basesyntax.models.Human;
import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private BetDao betDao;

    @Inject
    private HumanDao humanDao;

    public void handler() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            Human human = null;
            try {
                String[] data = command.split(" ");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                int value = Integer.parseInt(data[2]);
                double risk = Double.parseDouble(data[3]);
                human = new Human(name, age);
                bet = new Bet(value, risk);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Enter data correctly");
            }
            humanDao.add(human);
            System.out.println(human == null ? null : human.toString());
            betDao.add(bet);
            System.out.println(bet == null ? null : bet.toString());
        }
    }
}
