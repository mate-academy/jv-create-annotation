package core.basesyntax.storage;

import core.basesyntax.model.User;
import java.util.ArrayList;
import java.util.List;

public class ListStorageUser {
    public static List<User> userList = new ArrayList<>();

    public void addUser(User user) {
        userList.add(user);
        System.out.println(user + " User added.");
    }
}
