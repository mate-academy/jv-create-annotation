package core.basesyntax.controller.controller;

import core.basesyntax.controller.dao.BetDao;
import core.basesyntax.controller.dao.BetDaoImpl;
import core.basesyntax.controller.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    private final BetDao betDao = new BetDaoImpl();

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
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Enter please, valid data");
            }
            betDao.add(bet);
            System.out.println(bet == null ? null : bet.toString());
        }
    }
}
