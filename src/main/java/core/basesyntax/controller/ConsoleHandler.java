package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    BetDao betDao;

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
                int amount = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(amount, risk);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Please enter numbers in an appropriate format.");
                continue;
            }
            betDao.add(bet);
            System.out.println(bet);
        }
    }
}
