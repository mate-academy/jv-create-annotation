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

                checkNegativeValue(value);
                checkNegativeRisk(risk);

                bet = new Bet(value, risk);
            } catch (IllegalArgumentException e) {
                System.out.println("Your data is - " + bet.toString());
                throw new RuntimeException("Enter only positive digital number.");
            }
            if (bet != null) {
                betDao.add(bet);
            }
        }
    }

    private void checkNegativeRisk(double risk) {
        if (risk < 0) {
            throw new IllegalArgumentException("Value is negative");
        }
    }

    private void checkNegativeValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value is negative");
        }
    }
}
