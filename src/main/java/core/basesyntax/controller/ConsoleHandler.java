package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PlayerDao;
import core.basesyntax.library.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Player;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private BetDao betDao;

    @Inject
    private PlayerDao playerDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            Player player = null;
            try {
                String[] betData = command.split(" ");
                String name = betData[0];
                int id = Integer.parseInt(betData[1]);
                int amount = Integer.parseInt(betData[2]);
                double risk = Double.parseDouble(betData[3]);
                bet = new Bet(amount, risk);
                player = new Player(name, id);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("You entered data in wrong format!");
            }
            if (bet != null && player != null) {
                betDao.add(bet);
                playerDao.add(player);
                System.out.println(player);
                System.out.println(bet);
            }
        }
    }
}
