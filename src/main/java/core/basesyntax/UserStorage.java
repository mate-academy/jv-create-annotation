package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {
    private Map<User, Bet> userList = new HashMap<>();

    public Map<User, Bet> getUserMap() {
        return userList;
    }
}
