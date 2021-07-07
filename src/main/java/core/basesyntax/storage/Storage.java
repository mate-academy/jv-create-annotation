package core.basesyntax.storage;

import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Bet> betList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    public List<Bet> getBetList() {
        return betList;
    }
}
