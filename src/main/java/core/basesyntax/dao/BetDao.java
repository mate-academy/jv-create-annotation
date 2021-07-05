package core.basesyntax.dao;

import core.basesyntax.model.Bet;
import java.util.List;

public interface BetDao {
    boolean addBet(Bet bet);

    List<Bet> getAllBets();

    boolean removeBet(Bet bet);
}
