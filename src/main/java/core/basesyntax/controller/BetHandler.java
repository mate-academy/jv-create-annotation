package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.impl.BetDaoImpl;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class BetHandler implements Handler {
    private static final int BET_VALUE_DATA = 0;
    private static final int BET_RISK_DATA = 1;
    private BetDao betDao = new BetDaoImpl();

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("Input your bet data");
        while (!(input = scanner.nextLine()).equals("q")) {
            Bet newBet = null;
            try {
                String[] parameters = input.split(" ");
                newBet = new Bet(Integer.parseInt(parameters[BET_VALUE_DATA]),
                        Double.parseDouble(parameters[BET_RISK_DATA]));
            } catch (NumberFormatException e) {
                System.out.println("Your bet data is not correct");
                continue;
            }
            betDao.add(newBet);
            System.out.println(newBet);
            System.out.println("Input one more bet parameters or q for exit");
        }
    }
}
