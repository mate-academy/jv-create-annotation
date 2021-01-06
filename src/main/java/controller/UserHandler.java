package controller;

import dao.PlayerDao;
import dao.impl.PlayerDaoImpl;
import model.Bet;
import model.Player;

import java.util.Scanner;

public class UserHandler implements ConsoleHandler {
    PlayerDao playerDao = new PlayerDaoImpl();
    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);

            String command = scanner.nextLine();
            try {
                String[] userData = command.split(" ");
                String nickname = userData[0];
                String password = userData[1];
                playerDao.addPlayer(new Player(nickname, password));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please,repeat with correct data");
                System.exit(1);
            }
    }
}
