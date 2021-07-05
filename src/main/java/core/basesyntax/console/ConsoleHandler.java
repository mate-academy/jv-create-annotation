package core.basesyntax.console;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImplementation;
import core.basesyntax.model.Bet;
import core.basesyntax.model.BetUser;
import java.util.Scanner;

public class ConsoleHandler {

    BetDao betDao = new BetDaoImplementation();

    public void readConsole() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            BetUser betUser = null;
            try {
                String[] data = line.split(" ");
                int betValue = Integer.valueOf(data[0]);
                double betRisk = Double.valueOf(data[1]);
                bet = new Bet(betValue, betRisk);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Please enter correct data");
            }
            if (bet != null) {
                betDao.add(bet);
                System.out.println(bet == null ? null : bet.toString());
            }
        }
    }
}
