package core.basesyntax.controller;

import core.basesyntax.dao.GenericDao;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class BetConsoleHandler implements ConsoleHandler {
    GenericDao<Bet> betDao;

    public BetConsoleHandler(GenericDao<Bet> betDao) {
        this.betDao = betDao;
    }

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter data for Bet, please!!!");
        while (true) {
            String consoleData = scanner.nextLine();
            if (consoleData.equals("q")) {
                return;
            }
            if (consoleData.isEmpty() || consoleData.split(" ").length != 2) {
                throw new IllegalArgumentException("Enter right quantity of parameters, please!!!");
            }
            try {
                String[] arrayData = consoleData.split(" ");
                int value = Integer.parseInt(arrayData[0]);
                double risk = Double.parseDouble(arrayData[1]);
                Bet bet = new Bet(value, risk);
                betDao.addModelToDb(bet);
            } catch (NumberFormatException e) {
                System.out.println("Enter right parameters, please!!!");
            }
        }
    }
}
