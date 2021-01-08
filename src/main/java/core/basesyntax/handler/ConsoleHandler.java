package core.basesyntax.handler;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler implements Handler {
    private BetDao betDao = new BetDaoImpl();

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Bet bet = null;
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                return;
            }
            try {
                String[] parseString = input.split(" ");
                int value = Integer.parseInt(parseString[0]);
                double risk = Integer.parseInt(parseString[1]);

                if (risk < 0 || value < 0) {
                    System.out.println("Value is negative");
                }
                bet = new Bet(value, risk);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Your data is - " + (bet != null ? bet.toString() : ""));
                throw new RuntimeException("Input isn't correct.");
            }
            if (bet != null) {
                betDao.add(bet);
            }
        }
    }
}
