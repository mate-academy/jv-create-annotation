package core.basesyntax.dao;

import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.List;

public interface UserDao {
    boolean addUser(User user);

    User getUserById(long id);

    List<User> getAllUsers();

    void changeUserPassword(long id, String newPassword);

    List<Bet> getAllUserBets(long id);
}
