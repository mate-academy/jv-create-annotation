package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    private BetDao betDao = new BetDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter value and risk for bet(enter 'q' for exit)."
                    + " For example: '10 1.5'");
            String commandBet = scanner.nextLine();
            if (commandBet.equalsIgnoreCase("q")) {
                System.out.println("Bets is over");
                return;
            }
            Bet bet = null;
            try {
                String[] betData = commandBet.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect data. Please, try again");
            }
            betDao.add(bet);
            System.out.println(bet != null ? bet.toString() : "Bet failed");
        }
    }
}
