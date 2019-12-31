package core.basesyntax.conroller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PlayerDao;
import core.basesyntax.exception.AgeException;
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
                String firstName = data[0];
                String lastName = data[1];
                int age = Integer.parseInt(data[2]);
                if (age < 18) {
                    throw new AgeException("Player doesn't have 18 years old ");
                }
                int value = Integer.parseInt(data[3]);
                double risk = Double.parseDouble(data[4]);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
                Player player = new Player(firstName, lastName, age, bet);
                playerDao.add(player);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Invalid date " + e);
            }
        }
    }
}
