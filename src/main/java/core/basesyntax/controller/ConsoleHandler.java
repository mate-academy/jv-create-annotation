package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.impl.BetDaoImpl;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    BetDao betDao = new BetDaoImpl();

    public void handle() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            String command = scan.nextLine();
            Bet bet = null;
            try {
                if (command.equalsIgnoreCase("q")) {
                    return;
                }
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Enter correct data");
            }
            betDao.add(bet);
            System.out.println(bet == null ? null : bet.toString());
        }
    }
}
