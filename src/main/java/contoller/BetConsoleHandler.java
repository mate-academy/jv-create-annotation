package contoller;

import dao.BetDao;
import dao.implementation.BetDaoImpl;
import java.util.Scanner;
import model.Bet;

public class BetConsoleHandler {
    public static final int BET_RISK = 1;
    public static final int BET_VALUE = 0;
    BetDao betDao = new BetDaoImpl();
    Scanner scanner = new Scanner(System.in);

    public void handleBet() {
        System.out.println("Please enter your bet and risk");
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet newBet = null;
            try {
                try {
                    String[] betData = command.split(" ");
                    int betValue = Integer.parseInt(betData[BET_VALUE]);
                    int betRisk = Integer.parseInt(betData[BET_RISK]);
                    newBet = new Bet(betValue, betRisk);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Please enter both bet and risk");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter valid value and risk");
            }
            betDao.add(newBet);
            System.out.println(newBet == null ? "No data" : newBet.toString());
        }
    }
}
