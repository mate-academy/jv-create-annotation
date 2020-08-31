package core.basesyntax.controller;

import core.basesyntax.dao.ModelDao;
import core.basesyntax.model.User;
import java.util.Scanner;

public class UserConsoleHandler implements ConsoleHandler {
    private ModelDao<User> userDao;

    public UserConsoleHandler(ModelDao<User> userDao) {
        this.userDao = userDao;
    }

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть будь ласка дані для User!!!");
        while (true) {
            String consoleData = scanner.nextLine();
            if (consoleData.equals("q")) {
                return;
            }
            String[] arrayData = consoleData.split(" ");
            String login = arrayData[0];
            String password = arrayData[1];
            User user = new User(login, password);
            userDao.addModelToDb(user);
        }
    }
}
