package core.basesyntax.handler;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.lib.Dao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler implements Handler {
    @Inject
    private BetDao betDao;
    @Dao
    private FruitDao fruitDao;

    private static final String EXIT = "q";
    private static final String SPACE_SEPARATOR = " ";

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Bet bet = null;
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase(EXIT)) {
                return;
            }
            try {
                String[] parseString = input.split(SPACE_SEPARATOR);
                int value = Integer.parseInt(parseString[0]);
                double risk = Integer.parseInt(parseString[1]);

                if (risk < 0 || value < 0) {
                    System.out.println("Value is negative");
                    continue;
                }
                bet = new Bet(value, risk);
                System.out.println(bet != null ? bet.toString() : "");
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter correct values. Your data is - "
                        + (bet != null ? bet.toString() : ""));
            }
            if (bet != null) {
                betDao.add(bet);
            }
        }
    }
}
