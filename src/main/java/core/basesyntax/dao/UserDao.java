package core.basesyntax.dao;

import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.List;

public interface UserDao {
    boolean isLegalGambling(User user);

    void saveAsGambler(User user);

    List<User> getAllGamblers();

    void makeBet(User user, Bet bet);
}
