package controller;

import dao.BetDao;
import dao.UserDao;
import java.util.Scanner;
import lib.Inject;
import model.Bet;
import model.User;

public class ConsoleHandler {
    @Inject
    private BetDao betDao;
    @Inject
    private UserDao userDao;

    public void createBet() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("stop")) {
                return;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                bet = new Bet(Integer.parseInt(betData[0]), Double.parseDouble(betData[1]));
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input, please enter the data correctly.");
            }
            betDao.add(bet);
            System.out.println("Bet added: " + bet);
            System.out.println("Add next one or write 'stop' to stop");
        }
    }

    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("stop")) {
                return;
            }
            User user = null;
            try {
                String[] userData = command.split(" ");
                user = new User(userData[0],userData[1]);
            } catch (NullPointerException e) {
                System.out.println("Incorrect input,"
                        + " please enter email and account number correctly");
            }
            userDao.add(user);
            System.out.println("User added: " + user);
            System.out.println("Add next one or write 'stop' to stop");
        }
    }
}
