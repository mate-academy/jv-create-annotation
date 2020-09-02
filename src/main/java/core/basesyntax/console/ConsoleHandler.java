package core.basesyntax.console;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetUserDao;
import core.basesyntax.factory.Factory;
import core.basesyntax.library.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.BetUser;
import java.util.Scanner;

public class ConsoleHandler {

    public static final String LETTER_Q = "q";
    @Inject
    BetDao betDao;
    @Inject
    BetUserDao betUserDao;

    public void readConsole() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase(LETTER_Q)) {
                return;
            }
            Bet bet = null;
            BetUser betUser = null;
            try {
                String[] data = line.split(" ");
                String name = data[0];
                String surname = data[1];
                int age = Integer.valueOf(data[2]);
                betUser = new BetUser(name, surname, age);
                int betValue = Integer.valueOf(data[3]);
                double betRisk = Double.valueOf(data[4]);
                bet = new Bet(betValue, betRisk, betUser);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Please enter correct data");
            }
            if (bet != null) {
                Factory.getBetUserDao().add(betUser);
                Factory.getBetDao().add(bet);
                System.out.println(bet == null ? null : bet.toString());
            }
        }
    }
}
