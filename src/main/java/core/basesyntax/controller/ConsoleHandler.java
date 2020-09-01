package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.library.Inject;
import core.basesyntax.models.Bet;
import core.basesyntax.models.User;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private BetDao betDao;
    @Inject
    private UserDao userDao;

    public void handle() {
        while (true) {
            String command = nextLine();
            switch (command.toLowerCase()) {
                case "r":
                    handleUser();
                    break;
                case "b":
                    handleBet();
                    break;
                case "q":
                    return;
                default:
                    System.out.println("Please enter correct command");
            }
        }
    }

    public void handleBet() {
        String command = nextLine();
        Bet bet = null;
        try {
            String[] betData = command.split(" ");
            bet = new Bet(Integer.parseInt(betData[0]), Double.parseDouble(betData[1]));
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Please enter correct data");
        }
        betDao.add(bet);
        System.out.println("Your bet is: " + bet);
        System.out.println(betDao.getAll());
    }

    public void handleUser() {
        String command = nextLine();
        User user = null;
        try {
            String[] userData = command.split(" ");
            user = new User(userData[0], Integer.parseInt(userData[1]));
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Please enter correct data");
        }
        userDao.add(user);
        System.out.println("Your name is: " + user.getName() + ". Your age is " + user.getAge());
        System.out.println(userDao.getAll());
    }

    public String nextLine() {
        return new Scanner(System.in).nextLine();
    }
}
