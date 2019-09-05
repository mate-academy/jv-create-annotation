package core.basesyntax.controller;

import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserEmailDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.User;
import core.basesyntax.model.UserEmail;

import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private static UserEmailDao userEmailDao;

    @Inject
    private static UserDao userDao;

    public static void handle() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String command = scanner.nextLine();
                if (command.equals("0")) {
                    return;
                }
                String[] data = command.split(" ");
                String login = data[0];
                String password = data[1];
                UserEmail userEmail = new UserEmail(login, password);
                userEmailDao.add(userEmail);

                String name = data[2];
                int age = Integer.parseInt(data[3]);
                User user = new User(name, age);
                userDao.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Данные введены некорректно");
        }
    }
}

