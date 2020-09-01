package core.basesyntax.model.dao;

import core.basesyntax.model.model.Bet;
import java.util.List;

public interface BetDao extends GenericDao<Bet> {

    @Override
    void add(Bet bet);

    @Override
    List<Bet> getAll();
}
