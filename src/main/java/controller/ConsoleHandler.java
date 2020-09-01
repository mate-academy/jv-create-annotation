package controller;

import dao.BetDao;
import dao.BetDaoImpl;
import dao.UserDaoImpl;
import model.Bet;
import model.User;
import services.UserService;

import java.util.Scanner;

public class ConsoleHandler {
    private static final int DATA_QUANTITY = 2;
    BetDao betDao = new BetDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        UserDaoImpl userDao = new UserDaoImpl();
        User user = null;

        System.out.println("Введите логин и пароль:");
        String creds = scanner.nextLine();
        String userData[] = creds.split(" ");
        if (userData.length != DATA_QUANTITY) {
            handle();
        }
        String login = userData[0];
        String password = userData[1];
        if (checkCreds(login, password)) {
            user = userDao.login(login, password);
        } else {
            handle();
        }
        System.out.println("Введите value и risk:");
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                break;
            }
            if (command.equalsIgnoreCase("pr")) {
                UserService userService = new UserService();
                userService.printUsersBetList(user.getUserName());
                break;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk, user);
                user.getBetsList().add(bet);

            } catch (NumberFormatException e) {
                System.out.println("Please, enter correct data");
            }
            betDao.add(bet);
            System.out.println(bet == null ? null : bet.toString());
        }
    }

    private boolean checkCreds(String login, String password) {
        if (login != null && password != null
                && login.length() > 3 && password.length() > 3) {
            return true;
        }
        System.out.println("Login and password can't be empty or shorter 3 symbols!");
        return false;
    }
}
