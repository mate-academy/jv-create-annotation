package core.basesyntax.controller;

import core.basesyntax.dao.Dao;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    private Dao<Bet> betDao;

    public ConsoleHandler(Dao<Bet> betDao) {
        this.betDao = betDao;
    }

    public void handler() {
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
                System.out.println("Enter right information, please!");
            }
            betDao.add(bet);

            System.out.println(bet == null ? null : bet.toString());
        }
    }
}
