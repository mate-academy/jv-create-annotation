package controller;

import dao.BetDao;
import dao.UserDao;
import lib.Inject;
import model.Bet;
import model.User;

import java.util.Scanner;

public class ConsoleHandler {

    @Inject
     private static  BetDao betDao;

    @Inject
    private static UserDao userDao;

    static public void handle() {
            try (Scanner scanner = new Scanner(System.in)){
                while (true) {
                    String command = scanner.nextLine();
                    if (command == "0") {
                        return;
                    }
                    String[] data = command.split(" ");
                    int value = Integer.parseInt(data[0]);
                    double risk = Double.parseDouble(data[1]);
                    String name = data[2];
                    int password = Integer.parseInt(data[3]);
                    Bet bet = new Bet(value, risk);
                    User user = new User(name, password);
                    betDao.add(bet);
                    userDao.add(user);
                }
            } catch (Exception e) {
                System.out.println("Данные введены некоректно");
            }
        }
    }

