package db;

import model.User;
import java.util.HashMap;
import java.util.Map;

public class UserStorage {
    public static final Map<String, User> userStorage = new HashMap<>();
}
