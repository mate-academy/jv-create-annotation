package core.basesyntax.controller;

import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.ServiceDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {

    private static final int FULLNAME_INDEX = 0;
    private static final int AGE_INDEX = 1;
    private static final int VALUE_INDEX = 2;
    private static final int RISK_INDEX = 3;
    private ServiceDao<Bet> betDao = new BetDaoImpl();
    private ServiceDao<User> userDao = new UserDaoImpl();

    public void handle() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            User user = null;
            try {
                String[] betData = command.split(";");
                int value = Integer.parseInt(betData[VALUE_INDEX]);
                double risk = Double.parseDouble(betData[RISK_INDEX]);
                bet = new Bet(value, risk);
                String fullname = betData[FULLNAME_INDEX];
                int age = Integer.parseInt(betData[AGE_INDEX]);
                user = new User(fullname, age, bet);
            } catch (NumberFormatException e) {
                System.out.println("Invalid data. Please enter your bet again.");
            }
            betDao.add(bet);
            userDao.add(user);
        }
    }
}
