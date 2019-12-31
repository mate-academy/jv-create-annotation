package core.basesyntax.src.controller;

import core.basesyntax.src.dao.BetDao;
import core.basesyntax.src.dao.PlayerDao;
import core.basesyntax.src.lib.Inject;
import core.basesyntax.src.model.Bet;
import core.basesyntax.src.model.Player;

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
            String[] data = command.split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            int value = Integer.parseInt(data[2]);
            double risk = Double.parseDouble(data[3]);
            try {
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
            } catch (Exception e) {
                System.out.println("Dao source wasn't found for a bet!");
            }
            try {
                Player player = new Player(name, age);
                playerDao.add(player);
            } catch (Exception e) {
                System.out.println("Dao source wasn't found for a player!");
            }
        }
    }
}
