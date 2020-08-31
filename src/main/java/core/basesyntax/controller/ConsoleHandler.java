package core.basesyntax.controller;

import core.basesyntax.dao.BedDaoImpl;
import core.basesyntax.dao.BetDao;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    BetDao betDao = new BedDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String enteredData = scanner.nextLine();
            if (enteredData.equalsIgnoreCase("q")) {
                return;
            }
            String[] betData = enteredData.trim().split(" ");
            Bet bet = null;
            try {
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Ви ввели неправильні дані, спробуйте ще раз!");
            }
            betDao.addBetToStorage(bet);
            System.out.println(bet == null ? null : bet.toString());
        }
    }
}
