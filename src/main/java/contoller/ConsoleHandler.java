package contoller;

import dao.BetDao;

import java.util.Scanner;

import lib.Inject;
import model.Bet;

public class ConsoleHandler {

    @Inject
    private static BetDao betDao;

    public static void handle() {

        while (true) {
            Scanner scan = new Scanner(System.in);
            String command = scan.nextLine();
            if (command.equals("0")) {
                return;
            }

            try {
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[0]);
                double risk = Double.parseDouble(data[1]);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
            } catch (Exception e) {
                System.out.println("Некоректный ввод данных!");
            }
        }
    }
}
