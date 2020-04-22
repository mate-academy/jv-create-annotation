package core.basesyntax.Controller;

import core.basesyntax.Model.Bet;
import core.basesyntax.Model.User;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;

import java.util.Scanner;

public class ConsolHandler {
    @Inject
    BetDao betDao;
    @Inject
    UserDao userDao;

    public void handler(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            User user = null;
            String[] betData = command.split(" ");
            try {
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
                String name = betData[2];
                int id = Integer.parseInt(betData[3]);
                user = new User(name, id);
            } catch (NumberFormatException e) {
                System.out.println("Введите корректные данные");
            }
            betDao.add(bet);
            userDao.add(user);
        }

        }
    }
