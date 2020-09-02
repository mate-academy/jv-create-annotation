package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.exception.DuplicateUserException;
import core.basesyntax.exception.InvalidAgeException;
import core.basesyntax.exception.InvalidLoginStringException;
import core.basesyntax.exception.InvalidStringBetException;
import core.basesyntax.exception.InvalidStringRegisterException;
import core.basesyntax.exception.UserNotAuthorizedException;
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
                        cursor = "\n[" + user.getLogin() + "] enter bet->";
                        continue;
                    case "/r":
                        register(data);
                        continue;
                    case "/h":
                        outputCommands();
                        continue;
                    case "/mb":
                        outputUserBets(user);
                        continue;
                    case "/signout":
                        user = signOut(user);
                        cursor = CURSOR_TEXT;
                        continue;
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
            } catch (InvalidLoginStringException e) {
                System.out.println("Invalid string. Example: [/l login password]");
            } catch (InvalidStringRegisterException e) {
                System.out.println("Invalid string. Example: [/r login password age]");
            } catch (UserNotAuthorizedException e) {
                System.out.println("You are not logged in");
            } catch (InvalidStringBetException e) {
                System.out.println("Invalid string. Enter value and risk, "
                        + "example: 100 0.1");
            }
        }
    }

    private void placeBet(String[] data, User user) throws InvalidStringBetException {
        if (data.length != 2) {
            throw new InvalidStringBetException("Invalid string. Enter value and risk, "
                    + "example: 100 0.1");
        }
        Bet bet = betMapper.parse(data);
        bet.setUserName(user.getLogin());
        betDao.add(bet);
        user.getBets().add(bet);
        System.out.println("Bet saved");
    }

    private User signOut(User user) throws UserNotAuthorizedException {
        if (user == null) {
            throw new UserNotAuthorizedException("You are not logged in");
        }
        System.out.println("Good bye");
        return null;
    }

    private void outputUserBets(User user) throws UserNotAuthorizedException {
        if (user == null) {
            throw new UserNotAuthorizedException("You need to log in");
        }
        user.getBets().forEach(System.out::print);
        System.out.println("");
    }

    private User authorize(String[] data) throws WrongLoginOrPasswordException,
            InvalidLoginStringException {
        if (data.length != 3) {
            throw new InvalidLoginStringException("Invalid string. "
                    + "Example: [/l login password]");
        }
        String login = data[1];
        String password = data[2];
        User user = authService.authorize(login, password);
        System.out.println("Successful authorization");
        return user;
    }

    private void register(String[] data) throws InvalidAgeException,
            DuplicateUserException, InvalidStringRegisterException {
        if (data.length != 4) {
            throw new InvalidStringRegisterException("Invalid string. "
                    + "Example: [/r login password age]");
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
