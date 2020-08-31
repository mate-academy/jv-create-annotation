package core.basesyntax.dao;

import core.basesyntax.model.Bet;
import core.basesyntax.model.User;

public class BetDaoImpl implements BetDao {
    private final User user;

    public BetDaoImpl(User user) {
        this.user = user;
    }

    @Override
    public void addBet(Bet bet) {
        user.addBet(bet);
    }

    @Override
    public Bet getBet(Integer id) {
        return user.getBet(id);
    }
}
