package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.List;
import java.util.stream.Collectors;

@Dao
public class BetDaoImpl implements BetDao {
    @Override
    public void add(Bet bet) {
        Storage.bets.add(bet);
    }

    @Override
    public List<Bet> getAllBetsForUser(User user) {
        return Storage.bets.stream()
                .filter(s -> s.getUser().equals(user))
                .collect(Collectors.toList());
    }

    @Override
    public List<Bet> getAllBets() {
        return Storage.bets;
    }
}
