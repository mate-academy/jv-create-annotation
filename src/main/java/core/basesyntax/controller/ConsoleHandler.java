package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.PlayerDao;
import core.basesyntax.dao.PlayerDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Player;
import java.util.Scanner;

public class ConsoleHandler {
    BetDao betDao = new BetDaoImpl();
    PlayerDao playerDao = new PlayerDaoImpl();

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
            betDao.add(bet);
            playerDao.add(player);
            if (bet != null && player != null) {
                System.out.println(player);
                System.out.println(bet);
            }
        }
    }
}
