package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.models.BetModel;
import java.util.Scanner;

public class ControllerHandler {
    private BetDao betDao = new BetDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            BetModel bet = null;
            try {
                String[] betData = command.split(" ");
                int betValue = Integer.parseInt(betData[0]);
                double betRisk = Double.parseDouble(betData[1]);
                bet = new BetModel(betValue, betRisk);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("The entered data is not correct");
            }
            betDao.add(bet);
            System.out.println(bet == null ? null : bet.toString());
        }
    }
}
