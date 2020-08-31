package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    private final BetDao betDao = new BetDaoImpl();

    public void handle() {
        System.out.println("Please enter your bet");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                return;
            }

            Bet bet = null;

            try {
                String[] values = input.split(" ");
                bet = new Bet(Integer.parseInt(values[0]), Double.parseDouble(values[1]));
            } catch (NumberFormatException e) {
                System.out.println("Please enter correct money and chance of victory values");
            }

            betDao.add(bet);
            if (bet != null) {
                System.out.println("Bet " + bet.toString() + " accepted");
            }
        }
    }
}
