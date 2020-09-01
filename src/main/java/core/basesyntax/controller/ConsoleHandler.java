package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.exception.DuplicateUserException;
import core.basesyntax.exception.InvalidAgeException;
import core.basesyntax.exception.WrongLoginOrPasswordException;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import core.basesyntax.service.AuthorizationService;
import core.basesyntax.service.Mapper;
import core.basesyntax.service.RegistrationService;
import java.util.Scanner;
import lombok.Setter;

public class ConsoleHandler {
    private static final String CURSOR_TEXT = "Need to log in [/l] or register [/r]. Help [/h]->";
    @Inject
    private BetDao betDao;
    @Setter
    private AuthorizationService authService;
    @Setter
    private RegistrationService regService;
    @Setter
    private Mapper<User> userMapper;
    @Setter
    private Mapper<Bet> betMapper;

    public void handle() {
        String cursor = CURSOR_TEXT;
        User user = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("");
            System.out.print(cursor);
            String line = scanner.nextLine();
            String[] data = line.split(" ");
            try {
                if (data[0].equals("/q")) {
                    return;
                }
                if (data[0].equals("/l")) {
                    if (data.length != 3) {
                        System.out.println("Invalid string. Example: [/l login password]");
                        continue;
                    }
                    String login = data[1];
                    String password = data[2];
                    user = authService.authorization(login, password);
                    cursor = "[" + login + "] enter bet->";
                    System.out.println("Successful authorization");
                    continue;
                }
                if (data[0].equals("/r")) {
                    if (data.length != 4) {
                        System.out.println("Invalid string. Example: [/r login password age]");
                        continue;
                    }
                    User newUser = userMapper.parse(data);
                    regService.registration(newUser);
                    System.out.println("Successful registration. "
                            + "Enter [/l login password] to enter");
                    continue;
                }
                if (data[0].equals("/h")) {
                    outputCommands();
                    continue;
                }
                if (data[0].equals("/mb")) {
                    if (user == null) {
                        System.out.println("You need to log in");
                        continue;
                    }
                    user.getBets().forEach(System.out::print);
                    System.out.println("");
                    continue;
                }
                if (data[0].equals("/signout")) {
                    if (user == null) {
                        System.out.println("You are not logged in");
                        continue;
                    }
                    user = null;
                    cursor = CURSOR_TEXT;
                    System.out.println("Good bye");
                    continue;
                }
                if (user != null) {
                    if (data.length != 2) {
                        System.out.println("Invalid string. Enter value and risk, "
                                + "example: 100 0.1");
                        continue;
                    }
                    Bet bet = betMapper.parse(data);
                    bet.setUserName(user.getLogin());
                    betDao.add(bet);
                    user.getBets().add(bet);
                    System.out.println("Bet saved");
                }
            } catch (WrongLoginOrPasswordException e) {
                System.out.println("Wrong login or password");
            } catch (InvalidAgeException e) {
                System.out.println("For adults only (18+)");
            } catch (DuplicateUserException e) {
                System.out.println("This login is busy");
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid data");
            }
        }
    }

    private void outputCommands() {
        String s = " ----------------- Commands ----------------- \n"
                + "| [/l login password] - authorization        |\n"
                + "| [/r login password age] - registration     |\n"
                + "| [/mb] - my bets                            |\n"
                + "| [/logout] - log out                        |\n"
                + "| [/h] - help                                |\n"
                + "| [/q] - exit                                |\n"
                + " ------------------------------------------";
        System.out.println(s);
    }
}
