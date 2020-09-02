package core.basesyntax.dao.bet;

import core.basesyntax.model.Bet;
import java.util.List;

public interface BetDao {
    void add(Bet bet);

    List<Bet> getAllBets();
}
