package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.HumanDao;
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
            Scanner in = new Scanner(System.in);
            String command = in.nextLine();
            if (command.equals("0")) {
                return;
            }
            try {
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[0]);
                double risk = Double.parseDouble(data[1]);
                String name = data[2];
                int age = Integer.parseInt(data[3]);
                Bet bet = new Bet(value, risk);
                Human human = new Human(name, age);
                betDao.add(bet);
                humanDao.add(human);
            } catch (Exception e) {
                System.out.println("please put correct data ");
            }
        }
    }
}
