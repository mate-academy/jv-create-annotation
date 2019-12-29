package controller;

import dao.BetDao;
import dao.HumanDao;
import lib.Inject;
import model.Bet;
import model.Human;

import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private static BetDao betDao;

    @Inject
    private static HumanDao humanDao;

    public static void handle() {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("0")) {
                return;
            }
            try {
                String[] data = command.split(" ");
                if (Integer.parseInt(data[1]) < 18) {
                    System.out.println("Acces denied. You are under 18.");
                    break;
                }
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                int value = Integer.parseInt(data[2]);
                double risk = Double.parseDouble(data[3]);
                Bet bet = new Bet(value, risk);
                Human human = new Human(name, age, bet);
                betDao.add(bet);
                humanDao.addHuman(human);
            } catch (Exception e) {
                System.out.println("Data invalid. Try enter \"name[ ]age[ ]value(int)[ ]risk(double)");
            }

        }
    }
}
