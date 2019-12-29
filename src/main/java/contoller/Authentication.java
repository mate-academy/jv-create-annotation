package contoller;

import dao.UserDao;

import java.util.Scanner;

import lib.Inject;

import model.User;

public class Authentication {

    @Inject
    private static UserDao userDao;

    public static void authentication() {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        try {
            String[] authenticData = command.split(" ");
            String login = authenticData[0];
            String password = authenticData[1];
            User user = new User(login, password);
            userDao.add(user);
        } catch (Exception e) {
            System.out.println("Некоректно введен логин или пароль!");
        }
    }
}
