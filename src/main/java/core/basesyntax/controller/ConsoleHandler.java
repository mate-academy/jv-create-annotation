package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.PlayerDao;
import core.basesyntax.dao.PlayerDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Player;
import java.util.Scanner;

public class ConsoleHandler {
    private final BetDao betDao = new BetDaoImpl();
    private final PlayerDao playerDao = new PlayerDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Please input correct data");
            }
            if (bet != null) {
                betDao.add(bet);
            }
            System.out.println(bet == null ? null : bet.toString());
            System.out.println(playerDao.getAll());
        }
    }

    public void handlePlayer() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("Start play")) {
                return;
            }
            String[] data = command.split(" ");
            String username = data[0];
            String password = data[1];
            if (username.length() == 0 || password.length() == 0) {
                System.out.println("Please input correct data");
            }
            Player player = new Player(username, password);
            playerDao.add(player);
        }
    }
}
