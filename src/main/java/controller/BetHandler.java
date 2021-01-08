package controller;

import dao.BetDao;
import dao.impl.BetDaoImpl;
import java.util.Scanner;
import model.Bet;

public class BetHandler implements ConsoleHandler {
    private BetDao betDao = new BetDaoImpl();

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
                betDao.add(bet);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Please,enter correct data");
                System.out.println(betDao.getAll().toString());
            }
            System.out.println(bet == null ? null : bet.toString());
        }
    }
}
