package core.basesyntax.handler;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler implements Handler {
    @Inject
    private BetDao betDao;
    @Inject
    private FruitDao fruitDao;

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
                    continue;
                }
                bet = new Bet(value, risk);
                System.out.println(bet);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter correct values.");
            }
            if (bet != null) {
                betDao.add(bet);
            }
        }
    }
}
