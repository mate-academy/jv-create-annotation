package core.basesyntax.dao;

import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.List;

public interface BetDao {
    void add(Bet bet);

    List<Bet> getAllBetsForUser(User user);

    public List<Bet> getAllBets();

}
