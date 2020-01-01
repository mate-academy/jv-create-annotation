package controller;

import dao.BetDao;
import dao.HumanDao;
import java.util.Scanner;
import lib.Inject;
import model.Bet;
import model.Human;

public class ConsoleHandler {

    @Inject
    public static BetDao betDao;

    @Inject
    public static HumanDao humanDao;

    public static void handle() {

        try {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String command = scanner.nextLine();
                if (command.equals("0")) {
                    return;
                }
                String[] data = command.split(" ");
                switch (data[0]) {
                    case "bet":
                        int value = Integer.parseInt(data[1]);
                        double risk = Double.parseDouble(data[2]);
                        Bet bet = new Bet(value, risk);
                        betDao.add(bet);
                        break;
                    case "human":
                        String name = data[1];
                        String surname = data[2];
                        Human human = new Human(name, surname);
                        humanDao.add(human);
                        break;
                    default:
                        System.out.println("Something wrong");
                }
            }
        } catch (Exception e) {
            System.out.println("Неправильные данные");
        }
    }
}

