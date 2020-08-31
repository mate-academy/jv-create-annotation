package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImp;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        BetDao betDao = new BetDaoImp();
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);

            } catch (NumberFormatException e) {
                System.out.println("Please, enter correct data!");
            }
            betDao.add(bet);
            System.out.println(bet == null ? null : bet.toString());
        }
    }
}
