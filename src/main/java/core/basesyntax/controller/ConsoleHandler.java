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
            if (command.equals("0")) {
                return;
            }
            try {
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[2]);
                double risk = Double.parseDouble(data[3]);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
                String playerName = String.valueOf(data[0]);
                int bank = Integer.parseInt(data[1]);
                Player player = new Player(playerName, bank);
                playerDao.add(player);
            } catch (Exception e) {
                System.out.println("Data has been entered incorrectly");
            }
        }

    }
}
