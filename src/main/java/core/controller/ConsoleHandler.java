package core.controller;

import core.dao.BetDao;
import core.dao.BetDaoImp;
import core.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    BetDao betDao = new BetDaoImp();

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            try {
                String[] betData = input.split(" ");
                bet = new Bet(Integer.parseInt(betData[0]), Double.parseDouble(betData[1]));
            } catch (NumberFormatException e) {
                System.out.println("Input correct data, please");
            }
            betDao.add(bet);
            System.out.println(bet == null ? null : bet.toString());
        }
    }
}
