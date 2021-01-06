package core.basesyntax.handler;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class BetConsoleHandler implements Handler {
    BetDao betDao = new BetDaoImpl();

    @Override
    public void handler() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Bet bet;
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                return;
            }
            try {
                String[] parseString = input.split(" ");
                int value = Integer.parseInt(parseString[0]);
                double risk = Integer.parseInt(parseString[1]);
                bet = new Bet(value, risk);
                System.out.println(bet.toString());
            } catch (Exception e) {
                throw new RuntimeException("Enter only digital number.");
            }
            if (bet != null) {
                betDao.add(bet);
            }
        }
    }
}
