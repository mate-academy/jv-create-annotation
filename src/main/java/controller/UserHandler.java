package controller;

import dao.PlayerDao;
import dao.impl.PlayerDaoImpl;
import java.util.Scanner;
import model.Player;

public class UserHandler implements ConsoleHandler {
    private PlayerDao playerDao = new PlayerDaoImpl();

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        boolean isCorrectData = false;
        while (!isCorrectData) {
            String command = scanner.nextLine();
            Player player = null;
            try {
                String[] userData = command.split(" ");
                String nickname = userData[0];
                String password = userData[1];
                player = new Player(nickname, password);
                isCorrectData = true;
                playerDao.addPlayer(player);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please,repeat with correct data");
            }
            System.out.println(playerDao.getAll().toString());
        }
    }
}
