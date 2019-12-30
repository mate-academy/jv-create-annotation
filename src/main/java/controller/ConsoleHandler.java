package controller;

import dao.BetDao;
import lib.Inject;
import model.Bet;

import java.util.Scanner;

// принимает данные от пользователя через консоль

public class ConsoleHandler {
    @Inject
    private static BetDao betDao;

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
                Bet bet = new Bet(value, risk);

                betDao.add(bet);

            } catch (Exception e) {
                System.out.println("Wrong input! Input value and risk");
            }
        }
    }
}