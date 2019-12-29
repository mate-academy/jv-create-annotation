package controller;

import dao.betDao;
import dao.betDaoImpl;
import model.Bet;

import java.util.Scanner;

public class ConsoleHandler {
    //синглтоп(типа). Один экземпляр класса для работы. Подходит только для работы с
    //ннапример одной моделью и одным консолХэндлером
    static final betDao betDao = new betDaoImpl();

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
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
            } catch (Exception e) {
                System.out.println("Data invalid. Try enter \"Value[ ]risk\" again.");
            }

        }
    }
}
