package core.basesyntax.controller;

import core.basesyntax.dao.bet.BetDao;
import core.basesyntax.dao.bet.BetDaoImpl;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    private static final int DATA_ELEMENTS_COUNT = 2;
    private static final String INVALID_DATA_MESSAGE = "Input valid data or letter 'Q' to exit";

    BetDao betDao = new BetDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet;
            String[] enteredData;
            try {
                enteredData = line.split(" ");
                if (enteredData.length != DATA_ELEMENTS_COUNT) {
                    System.out.println(INVALID_DATA_MESSAGE);
                    continue;
                }
                bet = new Bet(Integer.parseInt(enteredData[0]),
                        Double.parseDouble(enteredData[1]));
                betDao.add(bet);
                System.out.println(bet.toString() + " has been added to storage!");
            } catch (NumberFormatException e) {
                System.out.println(INVALID_DATA_MESSAGE);
            }
        }
    }
}
