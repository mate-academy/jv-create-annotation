package core.basesyntax;

import java.util.Scanner;

public class ConsoleHandler {
    private Dao dao;
    private String command;
    private Scanner scanner;
    private final Splitter splitter;

    public ConsoleHandler() {
        dao = new UserDao();
        splitter = new Splitter();
    }

    public void handle() {
        System.out.println("Enter your password and login for game!");
        scanner = new Scanner(System.in);
        String[] input = splitter.split(scanner.nextLine());
        dao.save(new User(input[0], input[1]));
        System.out.println("Enter risk and value for your bet");
        dao = new BetDao();
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
        String[] input = splitter.split(command);
        try {
            dao.save(new Bet(Integer.parseInt(input[0]), Double.parseDouble(input[1])));
            System.out.println("Bet is saved!");
            appListen();
        } catch (NumberFormatException e) {
            throw new RuntimeException("Wrong bet format!");
        }
    }
}
