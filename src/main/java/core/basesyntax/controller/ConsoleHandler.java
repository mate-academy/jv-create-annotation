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
    private static final String CURSOR_TEXT = "\nNeed to log in [/l] or register [/r]. Help [/h]->";
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
            System.out.print(cursor);
            String line = scanner.nextLine();
            String[] data = line.split(" ");
            try {
                switch (data[0]) {
                    case "/q":
                        return;
                    case "/l":
                        user = authorize(data);
                        if (user != null) {
                            cursor = "\n[" + user.getLogin() + "] enter bet->";
                        }
                        break;
                    case "/r":
                        register(data);
                        break;
                    case "/h":
                        outputCommands();
                        break;
                    case "/mb":
                        outputUserBets(user);
                        break;
                    case "/signout":
                        user = signOut(user);
                        cursor = CURSOR_TEXT;
                        break;
                    default:
                        if (user != null) {
                            placeBet(data, user);
                        }
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

    private void placeBet(String[] data, User user) {
        if (data.length != 2) {
            System.out.println("Invalid string. Enter value and risk, "
                    + "example: 100 0.1");
            return;
        }
        Bet bet = betMapper.parse(data);
        bet.setUserName(user.getLogin());
        betDao.add(bet);
        user.getBets().add(bet);
        System.out.println("Bet saved");
    }

    private User signOut(User user) {
        if (user == null) {
            System.out.println("You are not logged in");
        } else {
            System.out.println("Good bye");
        }
        return null;
    }

    private void outputUserBets(User user) {
        if (user == null) {
            System.out.println("You need to log in");
            return;
        }
        user.getBets().forEach(System.out::print);
        System.out.println("");
    }

    private User authorize(String[] data) throws WrongLoginOrPasswordException {
        if (data.length != 3) {
            System.out.println("Invalid string. "
                    + "Example: [/l login password]");
            return null;
        }
        String login = data[1];
        String password = data[2];
        User user = authService.authorize(login, password);
        System.out.println("Successful authorization");
        return user;
    }

    private void register(String[] data) throws InvalidAgeException,
            DuplicateUserException {
        if (data.length != 4) {
            System.out.println("Invalid string. "
                    + "Example: [/r login password age]");
            return;
        }
        User newUser = userMapper.parse(data);
        regService.register(newUser);
        System.out.println("Successful registration. "
                + "Enter [/l login password] to enter");
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
