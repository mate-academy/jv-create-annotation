package core.basesyntax.controller;

import core.basesyntax.dao.interfaces.BetDao;
import core.basesyntax.dao.interfaces.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private BetDao betDao;
    @Inject
    private UserDao userDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please, enter login and password for your user!");
            String inputUser = scanner.nextLine();
            System.out.println("Please, enter value and risk for your bet!");
            String inputBet = scanner.nextLine();
            if (inputUser.equalsIgnoreCase("q") || inputBet.equalsIgnoreCase("q")) {
                break;
            }
            try {
                String[] user = inputUser.split(" ");
                String[] bet = inputBet.split(" ");
                userDao.add(new User(user[0],
                        user[1]));
                betDao.add(new Bet(Integer.parseInt(bet[0]),
                        Double.parseDouble(bet[1])));
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException exception) {
                System.out.println("Please, enter valid data");
            }

            System.out.println(betDao.getAll().toString());
            System.out.println(userDao.getAll().toString());
        }
    }
}
