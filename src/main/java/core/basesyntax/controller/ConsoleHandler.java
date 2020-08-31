package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHandler {
    BetDao betDao = new BetDaoImpl();
    UserDao userDao = new UserDaoImpl();

    public void handle() {
        while (true) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.println("Enter your name and id");
                String userInfo = reader.readLine();
                String[] userData = userInfo.split(" ");
                userDao.add(new User(userData[0], Integer.parseInt(userData[1])));

                System.out.println("Enter value and risk for your bet");
                String betInfo = reader.readLine();
                if (betInfo.equals(" ")) {
                    return;
                }
                String[] betData = betInfo.split(" ");
                betDao.add(new Bet(Integer.parseInt(betData[0]), Double.parseDouble(betData[1])));
            } catch (IOException e) {
                throw new RuntimeException("Unable to read data", e);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Please enter correct data", e);
            }
        }
    }
}
