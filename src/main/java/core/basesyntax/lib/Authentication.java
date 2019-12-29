package core.basesyntax.lib;

import core.basesyntax.dao.UserDao;
import core.basesyntax.model.User;
import java.util.Scanner;

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
            System.out.println("Wrong login or password!");
        }
    }
}
