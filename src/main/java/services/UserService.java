package services;

import db.UserStorage;
import model.Bet;

import java.util.List;

public class UserService {
    public List<Bet> printUsersBetList(String userName) {
        List<Bet> result = UserStorage.userStorage.get(userName).getBetsList();
        System.out.println(result);
        return result;
    }
}
