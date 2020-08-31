package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import core.basesyntax.model.UserDto;

import java.util.Scanner;

public class ConsoleHandler {
    public void handler() {

        while (true) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Would you like to 'r' - register,or 'e' - enter: ");
                String action = scanner.nextLine();
                if (action.equalsIgnoreCase("q")) {
                    return;
                }
                if (action.equalsIgnoreCase("r")) {
                    UserDao userDao = new UserDaoImpl();
                    userDao.addNewUser(readNewUser());
                }
                scanner.nextLine();
                if (action.equalsIgnoreCase("e")) {
                    User tepmUser = readUser();
                    Bet tempBet = new Bet();
                    while (true) {
                        System.out.println("Would you like to stop adding bets? Enter 'q'");
                        if (scanner.nextLine().equalsIgnoreCase("q")) {
                            return;
                        }
                        tempBet = readBet();
                        tempBet.setUserId(tepmUser.getUserId());
                        BetDao betDao = new BetDaoImpl();
                        betDao.add(tempBet);
                    }

                }
                System.out.println("Enter 'q' if you would like to quit: ");
                String actionQuit = scanner.nextLine();
                scanner.close();
            } catch (Exception e) {
//                scanner.nextLine();
                System.out.println("Enter correct data");
            }
        }
    }

    public Bet readBet() {
        Bet bet = new Bet();
        try (Scanner scanner = new Scanner(System.in)) {
            String command = scanner.nextLine();
            System.out.println("Please enter bet value and bet risk: ");
            String[] betData = command.split(" ");
            int value = Integer.parseInt(betData[0]);
            double risk = Double.parseDouble(betData[1]);
            bet.setRisk(value);
            bet.setRisk(risk);
        } catch (Exception e) {
            System.out.println("Please enter correct data: ");
        }
        return bet;
    }

    public User readUser() {
        UserDao userDao = new UserDaoImpl();
        String login = "";
        String password = "";
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter login: ");
            login = scanner.nextLine();
            System.out.println("Please enter password: ");
            password = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Entered data is incorrect: " + e);
        }
        return userDao.getUser(login, password);
    }

    public UserDto readNewUser() {
        UserDto userDto = new UserDto();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter login: ");
            userDto.setLogin(scanner.nextLine());
            System.out.println("Please enter password: ");
            userDto.setPassword(scanner.nextLine());
            System.out.println("Please enter name: ");
            userDto.setName(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Entered data is incorrect: " + e);
        }
        return userDto;
    }
}

