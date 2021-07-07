package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static List<Bet> betList = new ArrayList<>();
    private static List<User> userList = new ArrayList<>();

    public static List<User> getUserList() {
        return userList;
    }

    public static List<Bet> getBetList() {
        return betList;
    }
}
