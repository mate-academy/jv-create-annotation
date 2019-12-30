package core.basesyntax.controllers;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.LotteryDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Lottery;

import java.util.Scanner;

public class ConsoleHandler {

    private static Scanner scanner = new Scanner(System.in);
    private static String command;
    @Inject
    private static BetDao betDao;
    @Inject
    private static LotteryDao lotteryDao;

    public static void handle() {
        while (true) {
            command = scanner.nextLine();
            try {
                switch (command) {
                    case "0":
                        return;
                    case "1":
                        doBet();
                        return;
                    case "2":
                        doLottery();
                        return;
                    default:
                }
            } catch (Exception e) {
                System.out.println("Something wrong, please check!");
            }
        }
    }

    private static void doLottery() {
        System.out.println("Enter the amount of money and "
                + "5 digits on your choice splitted by space."
                + "\nTo exit, press 0");
        while (true) {
            command = scanner.nextLine();
            if (command.equals("0")) {
                return;
            }
            String[] data = command.split(" ");
            if (data[1].length() != 5) {
                System.out.println("Incorrect number");
                continue;
            }
            double sum = Double.parseDouble(data[0]);
            int number = Integer.parseInt(data[1]);
            Lottery lottery = new Lottery(sum, number);
            lotteryDao.add(lottery);
        }
    }

    private static void doBet() {
        System.out.println("Enter the bet and risk through the space."
                + "\nTo exit, press 0");
        while (true) {
            command = scanner.nextLine();
            if (command.equals("0")) {
                return;
            }
            String[] data = command.split(" ");
            int value = Integer.parseInt(data[0]);
            double risk = Double.parseDouble(data[1]);
            Bet bet = new Bet(value, risk);
            betDao.add(bet);
        }
    }
}
