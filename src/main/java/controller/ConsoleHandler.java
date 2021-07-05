package controller;

import dao.BetDao;
import dao.UserDao;
import java.util.List;
import java.util.Scanner;
import lib.Inject;
import model.Bet;
import model.User;

public class ConsoleHandler {
    private static final int DATA_QUANTITY = 2;
    private static final int LOGIN_PASSWORD_MIN_LENGTH = 3;

    @Inject
    private UserDao userDao;
    @Inject
    private BetDao betDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        User user = enterLoginPassword(scanner);
        enterValueAndRisk(scanner, user);
    }

    private User enterLoginPassword(Scanner scanner) {
        String login;
        String password;
        String[] userData;
        User user = null;
        while (true) {
            System.out.println("Введите логин и пароль:");
            String creds = scanner.nextLine();
            userData = creds.split(" ");
            login = userData[0];
            password = userData[1];
            if (isCredsValid(login, password)
                    && userData.length == DATA_QUANTITY) {
                user = new User(login, password);
                break;
            }
        }
        userDao.addUser(user);
        return user;
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
                continue;
            }

            betDao.add(bet);
        }
    }

    private boolean isCredsValid(String login, String password) {
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
