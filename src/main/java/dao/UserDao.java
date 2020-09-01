package dao;

import java.util.List;
import model.Bet;
import model.User;

public interface UserDao {
    User login(String userName, String password);

    User register(String userName, String password);

    List<Bet> getBetsByUserName(String userName);
}
