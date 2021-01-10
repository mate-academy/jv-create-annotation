package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.model.Bet;

import java.util.Scanner;

public class ConsoleHandler {


    public void handle() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")){
                return;
            }
            Bet bet = null;
            try {
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[0]);
                double risk = Double.parseDouble(data[1]);
                bet = new Bet(value, risk);

            } catch (NumberFormatException e) {
                System.out.println("Input correct data");
            }
            if (bet != null){
                BetDao betDao = new BetDaoImpl();
                betDao.add(bet);
            }
        }
    }
}
