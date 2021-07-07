package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.models.BetModel;
import core.basesyntax.models.UserModel;
import java.util.Scanner;

public class ControllerHandler {

    @Inject
    private BetDao betDao;
    @Inject
    private UserDao userDao;
    private Scanner scanner;

    public ControllerHandler() {
        this.scanner = new Scanner(System.in);
    }

    public void handleBet() {
        while (true) {
            String command = scanner.nextLine();
            if (isExitCommand(command)) {
                return;
            }
            BetModel bet = null;
            try {
                String[] betData = command.split(" ");
                int betValue = Integer.parseInt(betData[0]);
                double betRisk = Double.parseDouble(betData[1]);
                bet = new BetModel(betValue, betRisk);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("The input data is not correct");
            }
            betDao.add(bet);
            System.out.println(bet == null ? null : bet.toString());
        }
    }

    public void handleUser() {
        while (true) {
            String command = scanner.nextLine();
            if (isExitCommand(command)) {
                return;
            }
            UserModel user = null;
            try {
                String[] betData = command.split(" ");
                String nameUser = betData[0];
                int userBalance = Integer.parseInt(betData[1]);
                user = new UserModel(nameUser, userBalance);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("The input data is not correct");
            }
            userDao.addUser(user);
            System.out.println(user == null ? null : user.toString());
        }
    }

    private boolean isExitCommand(String str) {
        return str.equalsIgnoreCase("q");
    }
}
