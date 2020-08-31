package core.basesyntax.controller;

import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.impl.UserDaoImpl;
import core.basesyntax.model.User;
import java.util.Scanner;

public class UserHandler implements Handler {
    private static final int USER_NAME_DATA = 0;
    private static final int USER_AGE_DATA = 1;
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("Input your name and age");
        while (!(input = scanner.nextLine()).equals("q")) {
            User newUser = null;
            try {
                String[] parameters = input.split(" ");
                newUser = new User(parameters[USER_NAME_DATA],
                        Integer.parseInt(parameters[USER_AGE_DATA]));
            } catch (NumberFormatException e) {
                System.out.println("Your user data is not correct");
                continue;
            }
            userDao.add(newUser);
            System.out.println(newUser);
            System.out.println("Input one more user parameters or q for exit");
        }
    }
}
