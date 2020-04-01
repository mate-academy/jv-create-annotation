package controller;

import dao.BetDao;
import dao.HumanDao;
import java.util.Scanner;
import lib.Inject;
import model.Bet;
import model.Human;

public class ConsoleHandler {
    @Inject
    private static BetDao betDao;

    @Inject
    private static HumanDao humanDao;

    public static void handle() {
        while (true != false) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if ("q".equalsIgnoreCase(command)) {
                return;
            }
            try {
                String[] input = command.split(" ");
                int value = Integer.parseInt(input[0]);
                double risk = Double.parseDouble(input[1]);
                String name = input[2];
                int money = Integer.parseInt(input[3]);

                Bet bet = new Bet(value, risk);
                Human human = new Human(name, money);

                betDao.add(bet);
                humanDao.add(human);

            } catch (Exception e) {
                System.out.println("Wrong input! Input value, risk, "
                        + "name and amount of money, that you planing to loose");
            }
        }
    }
}
