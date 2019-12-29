package controller;

import dao.betDao;
import dao.betDaoImpl;
import model.Bet;

import java.util.Scanner;

public class ConsoleHandler {
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
                betDao betDao = new betDaoImpl();
                betDao.add(bet);
            } catch (Exception e) {
                System.out.println("Data invalid. Try enter \"Value[ ]risk\" again.");
            }

        }
    }
}
