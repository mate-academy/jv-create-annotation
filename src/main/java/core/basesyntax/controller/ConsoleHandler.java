package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    private BetDao betDao;

    public ConsoleHandler(BetDao betDao) {
        this.betDao = betDao;
    }

    public void handle() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
                System.out.println(bet);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter correct data");
            }
        }
    }
}
