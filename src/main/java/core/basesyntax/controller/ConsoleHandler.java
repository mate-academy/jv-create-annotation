package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PlayerDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Player;

import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private static BetDao betDao;
    @Inject
    private static PlayerDao playerDao;

    public static void handle() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("")) {
                return;
            }
            try {
                String[] data = command.split(" ");
                String name = data[0];
                int moneyAmount = Integer.parseInt(data[1]);
                int value = Integer.parseInt(data[2]);
                double risk = Double.parseDouble(data[3]);
                Player player = new Player(name, moneyAmount);
                playerDao.add(player);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
            } catch (Exception e) {
                System.out.println("bad input data");
            }
        }
    }
}
