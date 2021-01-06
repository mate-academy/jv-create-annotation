package controller;

import dao.BetDao;
import dao.impl.BetDaoImpl;
import java.util.Scanner;
import model.Bet;

public class BetHandler implements ConsoleHandler {
    BetDao betDao = new BetDaoImpl();

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Please,enter correct data");
            }
            betDao.add(bet);
            System.out.println(bet == null ? null : bet.toString());
        }
    }
}
