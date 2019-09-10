package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetImp;
import core.basesyntax.dao.CustomersDao;
import core.basesyntax.dao.CustomersImp;
import core.basesyntax.lip.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Customers;

import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private static BetDao libraryDao;

    public static void handle() {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("0")) {
                return;
            }
            try {
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[0]);
                double risk = Double.parseDouble(data[1]);
                String name = data[2];
                int id = Integer.parseInt(data[3]);
                Bet bet = new Bet(value,risk);
                BetDao betDao = new BetImp();
                betDao.add(bet);
                Customers customers = new Customers(name,id);
                CustomersDao cusDao = new CustomersImp();
                cusDao.add(customers);
            } catch (Exception e) {
                System.err.println("Вводите данные через пробел");
            }
        }
    }
}
