package database;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Bet;
import model.User;

public class Storage {
    public static List<Bet> bets = new ArrayList<>();
    public static Set<User> users = new HashSet<>();
}
