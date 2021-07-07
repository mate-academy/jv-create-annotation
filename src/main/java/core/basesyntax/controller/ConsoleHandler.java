package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.PlayerDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Player;
import java.util.Scanner;

public class ConsoleHandler {

    private Scanner scanner = new Scanner(System.in);
    private String command;

    @Inject
    private BetDao betDao;

    @Inject
    private PlayerDao playerDao;

    public void handle() {

        System.out.println("Введите команду: "
                + "\nbet, чтобы ввести ставку,"
                + "\nplayer, чтобы добавить нового игрока и"
                + "\nq, чтобы выйти из приложения");
        command = scanner.nextLine();
        switch (command) {
            case ("bet") :
                System.out.println("Введите value и risk для вашей ставки");
                betCommand();
                break;
            case ("player") :
                System.out.println("Введите имя нового игрока");
                playerCommand();
                break;
            case ("q") :
                return;
            default:
                System.out.println("Введите корректную команду");
        }
    }

    public void betCommand() {
        command = scanner.nextLine();
        Bet bet = null;
        try {
            String[] betData = command.split(" ");
            bet = new Bet(Integer.parseInt(betData[0]), Double.parseDouble(betData[1]));
        } catch (NumberFormatException e) {
            System.out.println("Введите корректные данные");
        }
        betDao.add(bet);
        System.out.println(bet != null ? bet.toString() : null);
    }

    public void playerCommand() {
        command = scanner.nextLine();
        Player player = new Player(command);
        playerDao.add(player);
    }
}
