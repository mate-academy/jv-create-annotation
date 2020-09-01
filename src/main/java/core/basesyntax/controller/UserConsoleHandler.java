package core.basesyntax.controller;

import core.basesyntax.dao.GenericDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.User;
import java.util.Scanner;

public class UserConsoleHandler implements ConsoleHandler {
    @Inject
    private GenericDao<User> userDao;

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter data for User, please!!!");
        while (true) {
            String consoleData = scanner.nextLine();
            if (consoleData.equals("q")) {
                return;
            }
            if (consoleData.isEmpty() || consoleData.split(" ").length != 2) {
                throw new IllegalArgumentException("Enter right quantity of parameters, please!!!");
            }
            String[] arrayData = consoleData.split(" ");
            String login = arrayData[0];
            String password = arrayData[1];
            User user = new User(login, password);
            userDao.addModelToDb(user);
        }
    }
}
