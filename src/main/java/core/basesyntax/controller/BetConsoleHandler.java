package core.basesyntax.controller;

import core.basesyntax.dao.ModelDao;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class BetConsoleHandler implements ConsoleHandler {
    ModelDao<Bet> betDao;

    public BetConsoleHandler(ModelDao<Bet> betDao) {
        this.betDao = betDao;
    }

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть будь ласка дані для Bet!!!");
        while (true) {
            String consoleData = scanner.nextLine();
            if (consoleData.equals("q")) {
                return;
            }
            try {
                String[] arrayData = consoleData.split(" ");
                int value = Integer.parseInt(arrayData[0]);
                double risk = Double.parseDouble(arrayData[1]);
                Bet bet = new Bet(value, risk);
                betDao.addModelToDb(bet);
            } catch (NumberFormatException e) {
                System.out.println("Введіть будь ласка коректні дані!!!");
            }
        }
    }
}
