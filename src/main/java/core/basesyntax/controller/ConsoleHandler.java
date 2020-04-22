package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PlayerDao;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Player;
import java.util.Scanner;

public class ConsoleHandler {
    @Dao
    private BetDao betDao;
    @Dao
    private PlayerDao playerDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please input your Name and your bet");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            Player player = null;
            try {
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[1]);
                double risk = Double.parseDouble(data[2]);
                String nickName = data[0];
                bet = new Bet(value, risk);
                player = new Player(nickName);
                betDao.add(bet);
                playerDao.add(player);
                System.out.println("Player " + player.getNickName() + " made a bet "
                        + bet.getValue() + " with risk " + bet.getRisk());
            } catch (NumberFormatException e) {
                System.out.println("Input correct data!");
            }
        }
    }
}
