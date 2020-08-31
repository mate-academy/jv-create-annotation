package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.models.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    private static final BetDao BET_DAO = new BetDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                bet = new Bet(Integer.parseInt(betData[0]), Double.parseDouble(betData[1]));
            } catch (NumberFormatException e) {
                System.out.println("Please enter correct data");
            }
            BET_DAO.add(bet);
        }
    }
}
