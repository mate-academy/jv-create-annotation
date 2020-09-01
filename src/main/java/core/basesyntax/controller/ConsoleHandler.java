package core.basesyntax.controller;

import core.basesyntax.dao.Dao;
import core.basesyntax.dao.impl.BetDaoImpl;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    private Dao<Bet> betDao = new BetDaoImpl();

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
                System.out.println(bet.toString());
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Введены некорректные данные. Пример корректных данных:100 0.1");
                continue;
            }
            betDao.add(bet);
        }
    }
}
