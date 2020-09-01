package dao;

import model.Bet;
import model.User;
import java.util.List;

public interface UserDao {
    User login(String userName, String password);

    User register(String UserName, String password);

    List<Bet> getBetsByUserName(String userName);
}
