package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    BetDao betDao = new BetDaoImpl();
    Bet bet;

    public void handle() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
                betDao.add(bet);
                System.out.println(bet);
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректные данные "
                        + "или нажмите 'q', чтобы выйти");
            }
        }
    }
}
