package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.imp.BetDaoImpl;
import core.basesyntax.model.Bet;

import java.util.Scanner;

public class ConsoleHandler {
    private BetDao betDao = new BetDaoImpl();

    public ConsoleHandler() {

    }

    public ConsoleHandler(BetDao betDao) {
        this.betDao = betDao;
    }

    public void handle() {
        System.out.println("Enter value and risk of bet");
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
                System.out.println("The entered data is incorrect");
            }
            betDao.add(bet);
            System.out.println(bet == null ? null : bet.toString());
        }
    }
}
