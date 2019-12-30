package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.library.Inject;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private static BetDao betDao;
    @Inject
    private static UserDao userDao;

    public static void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("0")) {
                return;
            }
            try {
                String[] data = command.split(" ");
                int id = Integer.parseInt(data[0]);
                userDao.add(new User(id, data[1]));
            } catch (NumberFormatException e) {
                System.out.println("Wrong entered data!");
            }
        }
    }
}
