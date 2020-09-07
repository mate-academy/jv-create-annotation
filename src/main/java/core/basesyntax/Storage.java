package core.basesyntax;

import java.util.Map;
import java.util.TreeMap;

public class Storage {
    private static final Map<Integer, Bet> betStorage = new TreeMap<>();
    private static final Map<Integer, User> userStorage = new TreeMap<>();

    public static Map<Integer, Bet> getBetStorage() {
        return betStorage;
    }

    public static Map<Integer, User> getUserStorage() {
        return userStorage;
    }
}
