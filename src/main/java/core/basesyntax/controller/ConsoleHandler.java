package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.OrderDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Order;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    BetDao betDao;

    @Inject
    OrderDao orderDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        if (command.equalsIgnoreCase("bet")) {
            System.out.println("Please, enter value and risk, for your bet");
            while (true) {
                command = scanner.nextLine();
//            String command = scanner.nextLine();
                if (command.equalsIgnoreCase("q")) {
                    return;
                }
                Bet bet = null;
                try {
                    String[] betData = command.split(" ");
                    int value = Integer.parseInt(betData[0]);
                    double risk = Double.parseDouble(betData[1]);
                    bet = new Bet(value, risk);
                } catch (NumberFormatException e) {
                    System.out.println("Please, enter correct data");
                }
                betDao.add(bet);
                System.out.println(bet == null ? null : bet.toString());
            }
        } else if (command.equalsIgnoreCase("order")) {
            System.out.println("Please, enter name of product and quantity, for your order");
            while (true) {
                command = scanner.nextLine();
//            String command = scanner.nextLine();
                if (command.equalsIgnoreCase("q")) {
                    return;
                }
                Order order = null;
                try {
                    String[] orderData = command.split(" ");
                    String nameOfProduct = orderData[0];
                    int quantity = Integer.parseInt(orderData[1]);
                    order = new Order(nameOfProduct, quantity);
                } catch (NumberFormatException e) {
                    System.out.println("Please, enter correct data");
                }
                orderDao.add(order);
                System.out.println(order == null ? null : order.toString());
            }
        }
    }
}
