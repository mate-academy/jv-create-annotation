package core.basesyntax;

import java.util.Scanner;

public class ConsoleHandler {
    private BetDao betDao;
    private UserDao userDao;
    private String command;
    private Scanner scanner;
    private Splitter splitter;

    public ConsoleHandler() {
        userDao = new UserDao();
        betDao = new BetDao();
        splitter = new Splitter();
    }

    public void handle() {
        System.out.println("Enter your password and login for game!");
        scanner = new Scanner(System.in);
        String[] input = splitter.split(scanner.nextLine());
        userDao.save(new User(input[0], input[1]));
        System.out.println("Enter risk and value for your bet");
        appListen();
    }

    private void appListen() {
        command = scanner.nextLine();
        try {
            inputManage();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            appListen();
        }
    }

    private void inputManage() {
        if (command.equals("quit")) {
            System.exit(0);
        }
        String[] input = splitter.split(command);
        try {
            betDao.save(new Bet(Integer.parseInt(input[0]), Double.parseDouble(input[1])));
            System.out.println("Bet is saved!");
            appListen();
        } catch (NumberFormatException e) {
            throw new RuntimeException("Wrong bet format!");
        }
    }
}
