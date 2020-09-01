package controller;

import dao.BetDao;
import dao.UserDao;
import java.util.List;
import java.util.Scanner;
import model.Bet;
import model.User;

public class ConsoleHandler {
    private static final int DATA_QUANTITY = 2;
    private static final int LOGIN_PASSWORD_MIN_LENGTH = 3;

    private UserDao userDao;
    private BetDao betDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        User user = enterLoginPassword(scanner);
        enterValueAndRisk(scanner, user);
    }

    private User enterLoginPassword(Scanner scanner) {
        System.out.println("Введите логин и пароль:");
        String creds = scanner.nextLine();
        String[] userData = creds.split(" ");
        if (userData.length != DATA_QUANTITY) {
            handle();
        }
        String login = userData[0];
        String password = userData[1];
        if (!checkCreds(login, password)) {
            handle();
        }
        return userDao.login(login, password);
    }

    private void enterValueAndRisk(Scanner scanner, User user) {
        Bet bet = null;
        System.out.println("Введите value и risk:");
        while (true) {
            String command = scanner.nextLine();
            if (isCommandTerminate(command, user)) {
                break;
            }
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk, user);
                user.getBetsList().add(bet);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Please, enter correct data");
            }
            betDao.add(bet);
        }
    }

    private boolean checkCreds(String login, String password) {
        if (login != null && password != null
                && login.length() > LOGIN_PASSWORD_MIN_LENGTH
                && password.length() > LOGIN_PASSWORD_MIN_LENGTH) {
            return true;
        }
        System.out.println("Login and password can't be empty or shorter 3 symbols!");
        return false;
    }

    private boolean isCommandTerminate(String command, User user) {
        if (command.equalsIgnoreCase("q")) {
            return true;
        }
        if (command.equalsIgnoreCase("print")) {
            printUsersBetList(user);
            return true;
        }
        return false;
    }

    private List<Bet> printUsersBetList(User user) {
        List<Bet> result = user.getBetsList();
        System.out.println(result);
        return result;
    }
}
