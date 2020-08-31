package core.basesyntax.model;

import static core.basesyntax.controller.ControllerHandler.checkArgsFailed;

import core.basesyntax.db.Storage;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class User {
    private static final String LOGIN_MATCHER = "[A-Za-z0-9\\d]+";
    private static final int MIN_LOGIN_SIZE = 8;
    private static final int MAX_LOGIN_SIZE = 20;
    private final String login;
    private final UserDto userData;

    public User(String login, int age) {
        this.login = login;
        userData = new UserDto(age);
    }

    public static void checkPresence(User user) {
        if (user == null) {
            throw new NoSuchElementException("No such element found");
        }
    }

    public static void loginCheck(String login) {
        if (login == null || login.length() == 0) {
            checkArgsFailed("Login can't be empty");
        }
        if (login.length() < MIN_LOGIN_SIZE) {
            checkArgsFailed("Login can't be smaller than "
                    + MIN_LOGIN_SIZE
                    + " characters");
        }
        if (login.length() > MAX_LOGIN_SIZE) {
            checkArgsFailed("Login can't be bigger than "
                    + MAX_LOGIN_SIZE
                    + " characters");
        }
        if (!login.matches(LOGIN_MATCHER)) {
            checkArgsFailed("Login may consist of digits, lowercase and capital letters only");
        }
    }

    public static boolean exists(String login) {
        return Storage.STORAGE.containsKey(login);
    }

    public void addBet(Bet bet) {
        userData.addBet(bet);
    }

    public Bet getBet(Integer id) {
        return userData.getBet(id);
    }

    public String getLogin() {
        return login;
    }

    private static class UserDto {
        private final HashMap<Integer, Bet> bets;
        private int age;

        public UserDto(int age) {
            this.age = age;
            bets = new HashMap<>();
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void addBet(Bet bet) {
            Bet.checkPresence(bet);
            int id = bet.getId();
            bets.put(id, bet);
        }

        public boolean betExists(Bet bet) {
            Bet.checkPresence(bet);
            prevBetsPresenceCheck();
            return bets.entrySet().contains(bet);
        }

        public Bet getBet(Integer id) {
            prevBetsPresenceCheck();
            if (!bets.containsKey(id)) {
                throw new IllegalArgumentException("Invalid input arguments");
            }
            return bets.get(id);
        }

        private void prevBetsPresenceCheck() {
            if (bets.isEmpty()) {
                throw new IllegalArgumentException("Invalid input arguments");
            }
        }
    }
}





