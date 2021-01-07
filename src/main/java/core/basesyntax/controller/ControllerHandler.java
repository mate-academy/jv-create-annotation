package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ControllerHandler {
    private static final String QUIT = "q";
    private static final int BET = 0;
    private static final int RISK = 1;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        BetDao betDao = new BetDaoImpl();

        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase(QUIT)) {
                return;
            }
            try {
                String[] splitData = command.split(" ");
                int betValue = Integer.parseInt(splitData[BET]);
                double riskValue = Double.parseDouble(splitData[RISK]);
                Bet bet = new Bet(betValue, riskValue);
                betDao.add(bet);
                Storage.bets.stream().forEach(System.out::println);
            } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
                throw new RuntimeException("Please enter a correct data");
            }
        }
    }
}
