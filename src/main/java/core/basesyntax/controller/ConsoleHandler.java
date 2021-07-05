package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.CarDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Car;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private BetDao betDao;
    @Inject
    private CarDao carDao;

    public void handle() {
        System.out.println("Please enter your bet");
        Scanner scanner = new Scanner(System.in);
        carDao.add(new Car("DeLorean", 300));

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
