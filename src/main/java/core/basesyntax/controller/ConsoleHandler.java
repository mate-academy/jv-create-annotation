package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.HumanDao;
import core.basesyntax.lib.BetInject;
import core.basesyntax.lib.HumanInject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Human;

import java.util.Scanner;

public class ConsoleHandler {
    @BetInject
    private static BetDao betDao;
    @HumanInject
    private static HumanDao humanDao;

    public static void handle() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("0")) {
                return;
            }
            try {
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[0]);
                double risk = Double.parseDouble(data[1]);
                String name = data[2];
                Bet bet = new Bet(value, risk);
                Human human = new Human(name);
                betDao.add(bet);
                humanDao.add(human);
            } catch (Exception e) {
                System.out.println("Data entered incorrectly");
            }
        }
    }
}
