package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private BetDao betDao;

    public void handle() {
        System.out.println("Please enter your bet");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                return;
            }
            try {
                String[] values = input.split(" ");
                Bet bet = new Bet(Integer.parseInt(values[0]), Double.parseDouble(values[1]));
                betDao.add(bet);
                System.out.println("Bet " + bet.toString() + " accepted");
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Please enter correct money and chance of victory values");
            }
        }
    }
}
